package com.microservices.order.service;

import com.microservices.order.client.InventoryClient;
import com.microservices.order.dto.DecreaseStockRequest;
import com.microservices.order.model.OrderModel;
import com.microservices.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public OrderModel createOrder(Long customerId, String productName, int quantity, BigDecimal totalPrice) {

        boolean stockAvailable = false;

        try {
            System.out.println("Calling inventory for product: " + productName);

            DecreaseStockRequest request = new DecreaseStockRequest();
            request.setProductName(productName);
            request.setQuantity(quantity);

            stockAvailable = inventoryClient.decreaseStock(request);
            System.out.println("Stock available: " + stockAvailable);
            
        } catch (Exception e) {
            System.out.println("Error calling inventory-service: " + e.getMessage());
            e.printStackTrace();
        }

        OrderModel order = new OrderModel();
        order.setCustomerId(customerId);
        order.setProductName(productName);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDate.now());

        order.setOrderStatus(stockAvailable ? "CONFIRMED" : "FAILED");

        return orderRepository.save(order);
    }
}