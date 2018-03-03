package com.falcon.wolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WolfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }
}
