package com.falcon.wolf.resource;

import com.falcon.wolf.dto.CustomerDTO;

public interface CustomerResource {

    Response sayHello(String msg);

    void saveCustomer(CustomerDTO customerDTO);
}
