package com.jev.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jev.order.model.Order;
import com.jev.order.service.OrderService;
import com.jev.order.vo.ResponseTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
    //     Order order = orderService.getOrderById(id);
    //     return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    // }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping(path = "/produk/{id}")
    public List<ResponseTemplate> getOrderWithProductById(@PathVariable("id") Long id) {
        return orderService.getOrderWithProductById(id);
    }

    @GetMapping("/product/{id}") 
    public List<ResponseTemplate> getOrderWithProduct(@PathVariable("id") Long id) {
        return orderService.getOrderWithProductById(id);
    }

    // @PutMapping(path = "{id}")
    // public void updateOrder(@PathVariable("id") Long id, 
    //     @RequestParam(required = false) int cost,
    //     @RequestParam(required = false) String unit) {
    //         orderService.updateOrder(id, cost, unit);
    //     }
    // )

    @PostMapping
    public Order creatOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        orderService.sendMessage(message);
        return "Message sent: " + message;
    }
}
