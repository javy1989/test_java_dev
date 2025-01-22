package com.rbravo.ms_customer.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for rabbitmq configuration
 *
 * @author rbravo
 */
@Configuration
public class RabbitMQConfig {

    @Value("${app.rabbit.client.exchange}")
    private String clientExchange;

    @Value("${app.rabbit.client.created-queue}")
    private String clientCreatedQueue;

    @Value("${app.rabbit.client.created-routing-key}")
    private String clientCreatedRoutingKey;

    @Bean
    public DirectExchange clientExchange() {
        return new DirectExchange(clientExchange);
    }

    @Bean
    public Queue clientCreatedQueue() {
        return new Queue(clientCreatedQueue, true);
    }

    @Bean
    public Binding clientCreatedBinding(Queue clienteCreadoQueue, DirectExchange clienteExchange) {
        return BindingBuilder.bind(clienteCreadoQueue).to(clienteExchange).with(clientCreatedRoutingKey);
    }


    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}

