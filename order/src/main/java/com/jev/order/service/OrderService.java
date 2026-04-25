package com.jev.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.jev.order.model.Order;
import com.jev.order.repository.OrderRepository;
import com.jev.order.vo.Produk;
import com.jev.order.vo.ResponseTemplate;

@Service
public class OrderService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        Order saved = orderRepository.save(order);

        Map<String, Object> dto = new HashMap<>();
        dto.put("id", saved.getId());
        dto.put("product_id", saved.getProduct_id());
        dto.put("customer_id", saved.getCustomer_id());
        dto.put("cost", saved.getCost());
        dto.put("unit", saved.getUnit());

        restTemplate.postForObject("http://localhost:8080/api/producer/send", dto, String.class);
        return saved;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<ResponseTemplate> getOrderWithProductById(Long id) {
        List<ResponseTemplate> responseList = new ArrayList<>();

        Order order = getOrderById(id);
        if (order == null) {
            throw new RuntimeException("Order not found with id: " + id);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUK");
        if (instances == null || instances.isEmpty()) {
            throw new RuntimeException("PRODUK service is not available in Eureka");
        }

        ServiceInstance serviceInstance = discoveryClient.getInstances("PRODUK").get(0);
        Produk product = restTemplate.getForObject(serviceInstance.getUri() + "/api/product/" + order.getProduct_id(), Produk.class);
        System.out.println("Resolved URI: " + serviceInstance.getUri());

        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduct(product);
        responseList.add(vo);
        
        return responseList;
    }

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("", queue.getName(), message);
    }
}
