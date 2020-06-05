package com.luv2code.service;

import com.luv2code.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);

    List<Customer> searchCustomers(String theSearchName);

}
