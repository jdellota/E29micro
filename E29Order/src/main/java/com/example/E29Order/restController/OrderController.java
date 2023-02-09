package com.example.E29Order.restController;

import com.example.E29Order.entity.OrderEntity;
import com.example.E29Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/orderapi")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addorder")
    public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.addOrder(orderEntity);
    }
    @GetMapping("/get")
    public ResponseEntity<List<OrderEntity>> addOrder() {
        return orderService.getAllOrders();
    }


    @GetMapping(path = "/getorder/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Long id) {

        return orderService.getOrder(id);
    }

    @GetMapping(path = "/getorders/user/{id}")
    public ResponseEntity<Long[]> getOrderByUserId(@PathVariable long id) {
        if (orderService.getProductidByUserId(id).length != 0) {
            return ResponseEntity.ok(orderService.getProductidByUserId(id));
        } else
            return new ResponseEntity<>(orderService.getProductidByUserId(id), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<OrderEntity> deleteOrder(@PathVariable long id) {
        return orderService.deleteOrder(id);

    }

    public ResponseEntity<OrderEntity> updateOrder(OrderEntity orderEntity) {
        return orderService.updateOrder(orderEntity);
    }
}
