package com.falcon.wolf.service;

import com.falcon.wolf.entity.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Customer> findAll();
}
