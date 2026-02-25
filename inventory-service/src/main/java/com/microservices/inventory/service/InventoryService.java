package com.microservices.inventory.service;

import com.microservices.inventory.model.InventoryProduct;
import com.microservices.inventory.repository.InventoryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public boolean decreaseStock(@NonNull Long productId, int quantity) {
        InventoryProduct product = inventoryRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            return false;
        }

        product.setQuantity(product.getQuantity() - quantity);
        return true;
    }

    public List<InventoryProduct> findAll() {
        return inventoryRepository.findAll();
    }

    public InventoryProduct findById(@NonNull Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public InventoryProduct findByName(String name) {
        return inventoryRepository.findByProductName(name);
    }

    public InventoryProduct save(@NonNull InventoryProduct product) {
        return inventoryRepository.save(product);
    }

    public InventoryProduct update(@NonNull Long id, InventoryProduct product) {
        InventoryProduct existingProduct = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return inventoryRepository.save(existingProduct);
    }

    public void delete(@NonNull Long id) {
        inventoryRepository.deleteById(id);
    }
}