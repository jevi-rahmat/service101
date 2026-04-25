package com.jev.order.vo;

import com.jev.order.model.Order;
import lombok.Data;

@Data
public class ResponseTemplate {
    Order order;
    Produk product;
}
