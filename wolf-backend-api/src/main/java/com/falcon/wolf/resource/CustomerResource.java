package com.falcon.wolf.resource;

import com.falcon.wolf.dto.CustomerDTO;

import javax.ws.rs.BeanParam;
import java.util.List;

public interface CustomerResource {

    CustomerDTO saveCustomer(@BeanParam CustomerDTO customerDTO);

    List<CustomerDTO> findAll();
}
