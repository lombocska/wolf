package com.falcon.wolf.implementation;

import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.repository.CustomerRepository;
import com.falcon.wolf.service.CustomerService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("${customer.message.queue:customerMessageQueue}")
    private String customerMessageQueue;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               RabbitTemplate rabbitTemplate) {
        this.customerRepository = customerRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(this::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public void sendCustomerMessage(CustomerDTO customerDTO) {
        Map<String, String> actionMap = new HashMap<>();
        Gson gson = new Gson();
        String customerDTOJson = gson.toJson(customerDTO);
        actionMap.put("customer", customerDTOJson);
        log.info("Sending the index request through queue message");
        rabbitTemplate.convertAndSend(customerMessageQueue, actionMap);
    }

    private CustomerDTO fromCustomer(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .build();
    }
}
