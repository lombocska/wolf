package com.falcon.wolf.controller;

import com.falcon.wolf.implementation.CustomerDTO;
import com.falcon.wolf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/home")
    public List<CustomerDTO> home(Model model) {
        List<CustomerDTO> customerDTOs = customerService.findAll();
        model.addAttribute("customers", customerDTOs);
        return customerDTOs;
    }

    @RequestMapping("/")
    public String redirectToHome(){
        return "redirect:/home";
    }
}
