package com.ihsan.producer;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private Long id;
    private Long product_id;
    private Long customer_id;
    private Long cost;
    private Long unit;

    public MessageDTO() {}

    public MessageDTO(Long id, Long product_id, Long customer_id, Long cost, Long unit) {
        this.id = id;
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.cost = cost;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

    
}
