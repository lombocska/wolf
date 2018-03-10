package com.falcon.wolf.listener;

import com.falcon.wolf.entity.Customer;
import com.falcon.wolf.implementation.CustomerDTO;
import com.falcon.wolf.repository.CustomerRepository;
import com.falcon.wolf.test_util.TestUtil;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMessageListenerTest {

    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String EMAIL = "email";

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerMessageListener listener;
    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;

    @Test
    public void testReceiveMessage() {
        CustomerDTO dto = createCustomerDTO();

        listener.receiveMessage(createMessageMap(dto));

        verify(customerRepository).save(customerArgumentCaptor.capture());
        TestUtil.verifyObjectFieldsEquals(dto, customerArgumentCaptor.getValue());
    }

    private Map<String, String> createMessageMap(CustomerDTO dto) {
        Map<String, String> message = new HashMap<>();
        Gson gson = new Gson();
        message.put("customer", gson.toJson(dto));
        return message;
    }

    private CustomerDTO createCustomerDTO() {
        return CustomerDTO.builder()
                .name(NAME)
                .address(ADDRESS)
                .email(EMAIL)
                .build();
    }
}