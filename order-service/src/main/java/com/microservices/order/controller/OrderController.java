package com.microservices.order.controller;

import com.microservices.order.model.OrderModel;
import com.microservices.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderModel createOrder(
        @RequestParam Long customerId, 
        @RequestParam String productName, 
        @RequestParam int quantity, 
        @RequestParam BigDecimal totalPrice) {
        return orderService.createOrder(customerId, productName, quantity, totalPrice);
    }
}