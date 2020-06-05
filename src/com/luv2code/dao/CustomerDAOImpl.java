package com.luv2code.dao;

import com.luv2code.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery =
                currentSession.createQuery("FROM Customer order by lastName",Customer.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public void deleteCustomer(int id) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.get(Customer.class,id));

    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = null;
        if (theSearchName != null &&
        theSearchName.trim().length() > 0) {
            query = currentSession.createQuery("from Customer " +
                    "where lower(firstName) like :theName or lower(lastName) like :theName" , Customer.class);
            query.setParameter("theName","%" + theSearchName.toLowerCase() + "%");
        } else {
            query = currentSession.createQuery("from Customer",Customer.class);
        }
        List<Customer> customers = query.getResultList();

        return customers;
    }
}
