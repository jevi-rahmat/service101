package com.adib.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @RabbitListener(queues = "myQueue")
    public void receivedMessage(MessageDTO message) {
        System.out.println("id: " + message.getId());
        System.out.println("product_id: " + message.getProductId());
        System.out.println("customer_id: " + message.getCustomerId());
        System.out.println("cost: " + message.getCost());
        System.out.println("unit: " + message.getUnit());
    }
}
