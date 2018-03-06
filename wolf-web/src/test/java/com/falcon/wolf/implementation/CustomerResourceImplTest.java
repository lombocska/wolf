package com.falcon.wolf.implementation;

import com.falcon.wolf.dto.CustomerDTO;
import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.service.CustomerService;
import com.falcon.wolf.test_util.TestUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerResourceImplTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerResourceImpl customerResourceImpl;
    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;

    @Test
    public void testSaveCustomerParamNull() {
        thrown.expect(NullPointerException.class);
        customerResourceImpl.saveCustomer(null);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = createCustomer();
        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);
        customerResourceImpl.saveCustomer(createCustomerDTO());
        verify(customerService).saveCustomer(customerArgumentCaptor.capture());
        TestUtil.verifyObjectFieldsEquals(createCustomerDTO(), customerArgumentCaptor.getValue());
    }

    @Test
    public void testFindAllEmpty() {
        when(customerService.findAll()).thenReturn(Collections.emptyList());
        List<CustomerDTO> result = customerResourceImpl.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindAll() {
        when(customerService.findAll()).thenReturn(ImmutableList.of(createCustomer()));
        List<CustomerDTO> result = customerResourceImpl.findAll();
        assertFalse(result.isEmpty());
        TestUtil.verifyObjectFieldsEquals(createCustomerDTO(), result.get(0));
    }

    private Customer createCustomer() {
        return Customer.builder()
                .name("Carlsfeld ")
                .address("SomeAddress")
                .email("test@email.com")
                .build();
    }

    private CustomerDTO createCustomerDTO() {
        return CustomerDTO.builder()
                .name("Carlsfeld ")
                .address("SomeAddress")
                .email("test@email.com")
                .build();
    }
}