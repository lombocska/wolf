package com.falcon.wolf.controller;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.resource.CustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * CustomerController is a simple Controller.
 * It provides /home endpoint for list all of the customer from the db
 * in real-time with WebSocket help.
 */

@Controller
@RequestMapping
public class CustomerController {

    private final CustomerResource customerResource;

    @Autowired
    public CustomerController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @GetMapping("/home")
    public List<CustomerDTO> home(Model model) {
        List<CustomerDTO> customerDTOs = customerResource.findAll();
        model.addAttribute("customers", customerDTOs);
        return customerDTOs;
    }
}
