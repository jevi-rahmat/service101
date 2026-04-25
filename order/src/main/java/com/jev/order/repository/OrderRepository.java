package com.jev.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jev.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
