package com.microservices.customer.controller;

import com.microservices.customer.dto.LoginRequest;
import com.microservices.customer.dto.RegisterRequest;
import com.microservices.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        String response = customerService.register(request);

        if (response.contains("exists")) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = customerService.login(request);

        if (token == null) {
            return ResponseEntity.status(401).body("Invalid username or password, try again");
        }

        return ResponseEntity.ok(token);
    }
}