package com.falcon.wolf.implementation;

import com.falcon.wolf.repository.CustomerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    private static final String ADDRESS = "address";
    private static final String NAME = "name";
    private static final String EMAIL = "some@email.com";

    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private RabbitTemplate rabbitTemplate;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Test
    public void testFindAll() {
        customerServiceImpl.findAll();
        verify(customerRepository).findAll();
    }
}