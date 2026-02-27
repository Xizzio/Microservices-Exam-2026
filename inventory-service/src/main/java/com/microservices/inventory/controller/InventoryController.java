package com.microservices.inventory.controller;

import com.microservices.inventory.model.InventoryProduct;
import com.microservices.inventory.service.InventoryService;
import com.microservices.inventory.dto.DecreaseStockRequest;
import com.microservices.inventory.dto.StockResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryProduct>> getAllProducts() {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<InventoryProduct> createProduct(@RequestBody @NonNull InventoryProduct product) {
        return ResponseEntity.ok(inventoryService.save(product));
    }

    @PostMapping("/decrease")
    public ResponseEntity<StockResponse> decreaseStock(
            @RequestBody DecreaseStockRequest request) {

        StockResponse response = inventoryService.decreaseStock(
                request.getProductName(),
                request.getQuantity()
        );

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryProduct> updateProduct(
            @PathVariable @NonNull Long id,
            @RequestBody @NonNull InventoryProduct product) {

        InventoryProduct updated = inventoryService.update(id, product);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable @NonNull Long id) {
        inventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}