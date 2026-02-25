package com.microservices.order.repository;

import com.microservices.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    // Additional query methods can be defined here
}