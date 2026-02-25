package com.microservices.customer.service;

import com.microservices.customer.dto.LoginRequest;
import com.microservices.customer.dto.RegisterRequest;
import com.microservices.customer.model.Customer;
import com.microservices.customer.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        if (customerRepository.findByUsername(request.getUsername()).isPresent()) {
            return "This username already exists, try another one";
        }

        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            return "This email already exists, try another one or login";
        }

        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setUsername(request.getUsername());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));

        customerRepository.save(customer);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {
        Optional<Customer> optionalCustomer = customerRepository.findByUsername(request.getUsername());

        if (optionalCustomer.isEmpty()) {
            return null;
        }

        Customer customer = optionalCustomer.get();

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            return null;
        }

        return UUID.randomUUID().toString();
    }
}