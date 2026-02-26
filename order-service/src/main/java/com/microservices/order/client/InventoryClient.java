package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.order.dto.DecreaseStockRequest;

@FeignClient(name = "inventory-service", url = "http://inventory-service:8084")
public interface InventoryClient {
    @PostMapping("/api/products/decrease")
    boolean decreaseStock(@RequestBody DecreaseStockRequest request);
}