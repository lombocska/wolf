package com.falcon.wolf.service;

import com.falcon.wolf.implementation.CustomerDTO;
import javax.ws.rs.BeanParam;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();

    void sendCustomerMessage(@BeanParam CustomerDTO customerDTO);
}
