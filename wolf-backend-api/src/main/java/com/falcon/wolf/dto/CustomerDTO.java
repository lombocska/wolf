package com.falcon.wolf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;
    @NotBlank(message = "Customer name cannot be empty!")
    @Size(max = 50)
    private String name;
    @NotBlank(message = "Customer address cannot be empty!")
    @Size(max = 50)
    private String address;
    private String email;
}
