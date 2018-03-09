package com.falcon.listener;

import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.implementation.CustomerDTO;
import com.falcon.wolf.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void receiveMessage(Map<String, CustomerDTO> message) {
        log.info("Received customerMessageMap.");
        customerRepository.save(fromCustomerDTO(message.get("customerName")));
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
