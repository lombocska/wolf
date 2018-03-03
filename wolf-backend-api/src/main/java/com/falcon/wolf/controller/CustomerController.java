package com.falcon.wolf.controller;

import com.falcon.wolf.Response;
import com.falcon.wolf.resource.CustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerResource customerResource;

    @Autowired
    public CustomerController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @GetMapping(value = "/sayhello")
    public Response hello(@RequestParam(value = "name", required = false) String name) {
        return customerResource.sayHello(name);
    }
}
