package com.example.E29Order.service;

import com.example.E29Order.entity.OrderEntity;
import com.example.E29Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<OrderEntity> addOrder(OrderEntity orderEntity) {
        if (orderRepository.findByUseridAndProductid(orderEntity.getUserid(), orderEntity.getProductid()).isPresent()) {
            OrderEntity order = orderRepository.findByUseridAndProductid(orderEntity.getUserid(), orderEntity.getProductid()).get();
            int qty = order.getQty() + orderEntity.getQty();
            orderEntity.setQty(qty);
            orderEntity.setId(order.getId());
        } else {
            try {
                ResponseEntity<String> product = restTemplate.getForEntity("http://localhost:8083/product/api/get/" + orderEntity.getProductid(), String.class);
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return ResponseEntity.ok(orderRepository.save(orderEntity));
    }

    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    public ResponseEntity<OrderEntity> getOrder(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok((order.get()));
        }
    }

    public Long[] getProductidByUserId(Long userid) {
        List<OrderEntity> orders = orderRepository.findByUserid(userid);
        List<Long> productIds = new ArrayList<>();
        for (OrderEntity order : orders
        ) {
            productIds.add(order.getProductid());
        }
        return productIds.toArray(new Long[0]);
    }

    public ResponseEntity<OrderEntity> deleteOrder(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok(order.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<OrderEntity> updateOrder(OrderEntity orderEntity) {
        Optional<OrderEntity> order = orderRepository.findById(orderEntity.getId());
        if (order.isPresent()) {
            return ResponseEntity.ok(orderRepository.save(orderEntity));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
