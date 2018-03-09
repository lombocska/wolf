package com.falcon.wolf;

import com.falcon.wolf.listener.CustomerMessageListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
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

    @Value("${customer.message.queue:customerMessageQueue}")
    public String CUSTOMER_MESSAGE_QUEUE;

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(CUSTOMER_MESSAGE_QUEUE, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(CUSTOMER_MESSAGE_QUEUE);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(CUSTOMER_MESSAGE_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(CustomerMessageListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
