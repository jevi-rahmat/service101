package com.adib.consumer;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private Long id;
    private Long product_id;
    private Long customer_id;
    private Long cost;
    private Long unit;

    public MessageDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return product_id; }
    public void setProductId(Long product_id) { this.product_id = product_id; }

    public Long getCustomerId() { return customer_id; }
    public void setCustomerId(Long customer_id) { this.customer_id = customer_id; }

    public Long getCost() { return cost; }
    public void setCost(Long cost) { this.cost = cost; }

    public Long getUnit() { return unit; }
    public void setUnit(Long unit) { this.unit = unit; }
}
