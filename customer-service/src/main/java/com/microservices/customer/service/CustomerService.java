package com.microservices.customer.service;

import com.microservices.customer.dto.LoginRequest;
import com.microservices.customer.dto.RegisterRequest;
import com.microservices.customer.model.Customer;
import com.microservices.customer.repository.CustomerRepository;
import com.microservices.security.JwtService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder, JwtService jwtService) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
        Customer customer = customerRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtService.generateToken(customer.getUsername(), customer.getAdmin());
    }
}