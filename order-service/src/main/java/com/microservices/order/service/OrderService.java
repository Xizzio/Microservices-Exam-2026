package com.microservices.order.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "orderQueue")
    public void handleOrder(String orderMessage) {
        String[] orderDetails = orderMessage.split(",");
        int customerId = Integer.parseInt(orderDetails[0]);
        LocalDate orderDate = LocalDate.parse(orderDetails[1]);
        String productName = orderDetails[2];
        int quantity = Integer.parseInt(orderDetails[3]);
        double totalPrice = Double.parseDouble(orderDetails[4]);

        // implement database save logic here for order next

        // Send notification to notification-service via RabbitMQ
        String notificationMessage = "Your order of " + quantity + " " + productName + " has been placed for a total price of " + totalPrice + " kr. Expected delivery date: " + orderDate.plusDays(2);
        rabbitTemplate.convertAndSend("notificationQueue", notificationMessage);
    }
}