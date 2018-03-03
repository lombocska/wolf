package com.falcon.wolf.controller;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.resource.CustomerResource;
import com.falcon.wolf.resource.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerResource customerResource;

    @Autowired
    public CustomerController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @GetMapping("/home")
    public String welcome(Model model) {
        List<CustomerDTO> customerDTOs = customerResource.findAll();
        model.addAttribute("customers", customerDTOs);
        return "welcome";
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<CustomerDTO>> saveCustomers(@RequestBody List<CustomerDTO> customerDTOs) {
        customerDTOs.forEach(customerResource::saveCustomer);
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }
}
