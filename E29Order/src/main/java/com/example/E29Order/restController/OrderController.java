package com.example.E29Order.restController;

import com.example.E29Order.entity.OrderEntity;
import com.example.E29Order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderapi")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/addorder")
    public OrderEntity addOrder(OrderEntity orderEntity){
        return orderService.addOrder(orderEntity);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOrder(@PathVariable long id ) {
        orderService.deleteOrder(id);

    }

    public OrderEntity getOrder(long id) {
        return orderService.getOrder(id);
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return orderService.updateOrder(orderEntity);
    }
}
