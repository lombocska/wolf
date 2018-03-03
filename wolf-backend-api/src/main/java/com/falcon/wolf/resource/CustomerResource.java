package com.falcon.wolf.resource;

import com.falcon.wolf.dto.CustomerDTO;

import javax.ws.rs.BeanParam;

public interface CustomerResource {

    Response sayHello(String msg);

    void saveCustomer(@BeanParam CustomerDTO customerDTO);
}
