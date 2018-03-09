package com.falcon.wolf.implementation;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    @NotBlank(message = "Customer name cannot be empty!")
    @Size(max = 50)
    private String name;
    @NotBlank(message = "Customer address cannot be empty!")
    @Size(max = 50)
    private String address;
    private String email;
}