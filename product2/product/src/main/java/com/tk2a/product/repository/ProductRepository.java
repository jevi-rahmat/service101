package com.tk2a.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tk2a.product.model.Product;

import jakarta.transaction.Transactional;;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    void deleteByName(String name);
}
