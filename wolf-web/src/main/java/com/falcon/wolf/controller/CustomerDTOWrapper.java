package com.falcon.wolf.controller;

import com.falcon.wolf.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTOWrapper {
    private List<CustomerDTO> customerDTOList;
}
