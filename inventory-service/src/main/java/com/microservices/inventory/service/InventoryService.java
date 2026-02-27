package com.microservices.inventory.service;

import com.microservices.inventory.dto.StockResponse;
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
    public StockResponse decreaseStock(String productName, int quantity) {
        InventoryProduct product = inventoryRepository.findByProductNameIgnoreCase(productName);

        if (product == null) {
            return new StockResponse(
                    false,
                    "Product not found",
                    productName,
                    quantity,
                    0
            );
        }

        if (product.getQuantity() < quantity) {
            return new StockResponse(
                    false,
                    "Not enough stock available",
                    productName,
                    quantity,
                    product.getQuantity()
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        inventoryRepository.save(product);

        return new StockResponse(
                true,
                "Stock successfully reserved",
                productName,
                quantity,
                product.getQuantity()
        );
    }

    public List<InventoryProduct> findAll() {
        return inventoryRepository.findAll();
    }

    public InventoryProduct findById(@NonNull Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public InventoryProduct findByName(String name) {
        return inventoryRepository.findByProductNameIgnoreCase(name);
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