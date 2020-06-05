package com.luv2code.dao;

import com.luv2code.entity.Customer;

import javax.persistence.Entity;
import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public void deleteCustomer(int id);

    List<Customer> searchCustomers(String theSearchName);
}
