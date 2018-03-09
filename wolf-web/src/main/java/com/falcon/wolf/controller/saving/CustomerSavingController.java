package com.falcon.wolf.controller.saving;

import com.falcon.wolf.controller.CustomerResponse;
import com.falcon.wolf.implementation.CustomerDTO;
import com.falcon.wolf.implementation.EntityConstraintViolationException;
import com.falcon.wolf.service.CustomerService;
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * CustomerSavingController is a simple REST Controller.
 * It provides /save-customer endpoint to save customer by the RequestBody.
 * <p>
 * If /save-customer endpoint  is called SimpMessageTemplate will call the /topic/home endpoint to
 * send newly saved customer data to /home endpoint.
 */

@Slf4j
@RestController
@RequestMapping
public class CustomerSavingController {

    private final CustomerService customerService;
    private final SimpMessagingTemplate template;

    @Autowired
    public CustomerSavingController(CustomerService customerService,
                                    SimpMessagingTemplate template) {
        this.customerService = customerService;
        this.template = template;
    }

    @PostMapping(value = "/save-customer")
    public CustomerResponse saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        log.info("Received customer");
        try {
            customerService.sendCustomerMessage(customerDTO);
            template.convertAndSend("/topic/home", customerDTO);
        } catch (EntityConstraintViolationException ex) {
            return CustomerResponse.builder()
                    .statusCode(400)
                    .message(ImmutableList.of(ex.getMessage()))
                    .build();
        }
        return CustomerResponse.builder()
                .customerDTOs(customerDTO)
                .statusCode(200)
                .build();
    }
}
