package com.falcon.wolf.controller;

import com.falcon.wolf.implementation.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
public class CustomerResponse {

    private List<String> message;
    private CustomerDTO customerDTOs;
    private int statusCode;

}
