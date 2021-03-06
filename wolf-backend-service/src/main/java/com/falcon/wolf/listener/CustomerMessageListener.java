package com.falcon.wolf.listener;

import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.implementation.CustomerDTO;
import com.falcon.wolf.implementation.EntityConstraintViolationException;
import com.falcon.wolf.repository.CustomerRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class CustomerMessageListener {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerMessageListener(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void receiveMessage(Map<String, String> message) {
        log.info("Received customerMessageMap.");
        CustomerDTO customerDTO = new Gson().fromJson(message.get("customer"), CustomerDTO.class);
        try {
            Customer customer = customerRepository.save(fromCustomerDTO(customerDTO));
        } catch (DataIntegrityViolationException ex) {
            throw new EntityConstraintViolationException(Customer.class.getSimpleName(), customerDTO.getName());
        }
        log.info("Message processed.");
    }

    private Customer fromCustomerDTO(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .address(customerDTO.getAddress())
                .email(customerDTO.getEmail())
                .build();
    }
}
