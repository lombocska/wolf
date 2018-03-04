package com.falcon.wolf.controller;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.resource.CustomerResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class CusomerSavingController {

    private final CustomerResource customerResource;

    @Autowired
    public CusomerSavingController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @PostMapping(value = "/save-customer")
    public ResponseEntity<CustomerDTO> saveCustomers(@RequestBody CustomerDTO customerDTO) {
        log.info("Received customer: {}", customerDTO.getName());
        customerDTO = customerResource.saveCustomer(customerDTO);
        //TODO: some kind of stomp like js?
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
}
