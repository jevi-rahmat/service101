package com.azhim.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "order_queue")
    public void messageReceived(Order order) {
        System.out.println("{ 'id': " + order.getId() + 
            " 'customer_id:' " + order.getProduct_id() +
            " 'product_id:' " + order.getCustomer_id() +
            " 'product': " + order.getProduct() + 
            " 'cost:' " + order.getCost() + " }");
    }

}
