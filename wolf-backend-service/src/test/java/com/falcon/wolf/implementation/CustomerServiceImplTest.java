package com.falcon.wolf.implementation;

import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.repository.CustomerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Test
    public void testSaveCustomer() {
        customerServiceImpl.saveCustomer(Customer
                .builder()
                .address("SomeAddress")
                .build());
        verify(customerRepository).save(any(Customer.class));
    }

    @Test
    public void testFindAll() {
        customerServiceImpl.findAll();
        verify(customerRepository).findAll();
    }
}