package com.microservices.inventory.repository;

import com.microservices.inventory.model.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryProduct, Long> {
    InventoryProduct findByProductName(String productName);
}