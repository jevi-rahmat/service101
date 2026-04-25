package com.jev.order.model;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    public Long total = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product_id;
    private Long customer_id;
    private Long cost;
    private Long unit; 

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
