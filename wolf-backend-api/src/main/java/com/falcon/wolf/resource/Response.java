package com.falcon.wolf.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

    private Boolean success;
    private String message;
}
