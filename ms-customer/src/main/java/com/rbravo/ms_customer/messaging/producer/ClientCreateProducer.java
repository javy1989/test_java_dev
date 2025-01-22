package com.rbravo.ms_customer.messaging.producer;

import com.rbravo.ms_customer.messaging.model.ClientCreateMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Class that receives client creation messages
 *
 * @author rbravo
 */
@Service
public class ClientCreateProducer {

    @Value("${app.rabbit.client.exchange}")
    private String clientExchange;

    @Value("${app.rabbit.client.created-routing-key}")
    private String clientCreatedRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientCreateProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientCreateMessage(Long id, String identification) {
        ClientCreateMessage clientCreateMessage = new ClientCreateMessage();
        clientCreateMessage.setClientId(id);
        clientCreateMessage.setIdentification(identification);
        rabbitTemplate.convertAndSend(clientExchange, clientCreatedRoutingKey, clientCreateMessage);
    }
}
