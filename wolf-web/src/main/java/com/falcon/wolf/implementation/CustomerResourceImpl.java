package com.falcon.wolf.implementation;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.resource.CustomerResource;
import com.falcon.wolf.service.CustomerService;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Api("Customer Api Interface")
@Slf4j
@Service
public class CustomerResourceImpl implements CustomerResource {

    private final CustomerService customerService;

    @Autowired
    public CustomerResourceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Preconditions.checkNotNull(customerDTO);
        customerService.saveCustomer(fromCustomerDTO(customerDTO));
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerService.findAll()
                .stream()
                .map(this::fromCustomer)
                .collect(Collectors.toList());
    }

    private CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    private Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }
}
