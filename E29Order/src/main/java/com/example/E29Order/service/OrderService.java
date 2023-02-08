package com.example.E29Order.service;

import com.example.E29Order.entity.OrderEntity;
import com.example.E29Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public OrderEntity addOrder(OrderEntity orderEntity){
               return orderRepository.save(orderEntity);
    }


    public OrderEntity deleteOrder(long id) {
        return orderRepository.deleteById(id);
    }

    public OrderEntity getOrder(long id) {
        return orderRepository.getReferenceById(id);
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }
}
