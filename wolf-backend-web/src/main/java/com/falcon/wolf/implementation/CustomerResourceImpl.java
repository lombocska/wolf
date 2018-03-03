package com.falcon.wolf.implementation;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.resource.CustomerResource;
import com.falcon.wolf.service.CustomerService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerResourceImpl implements CustomerResource {

    private final CustomerService customerService;

    @Autowired
    public CustomerResourceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public String sayHello() {
        return "Hello!";
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Preconditions.checkNotNull(customerDTO);
        customerService.saveCustomer(fromCustomerDTO(customerDTO));
    }

    private Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}
