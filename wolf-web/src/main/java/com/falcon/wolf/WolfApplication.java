package com.falcon.wolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The WOLF implements an application that
 * provides solution Spring Boot - WebSocket STOMP - Thymeleaf combination.
 *
 * @author  Monika Lombos
 * @version 1.0
 * @since   2018-03-05
 */

@SpringBootApplication
@EnableAutoConfiguration
public class WolfApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }
}
