package com.example.E29Order.repository;

import com.example.E29Order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    public OrderEntity deleteById(long id);
}
