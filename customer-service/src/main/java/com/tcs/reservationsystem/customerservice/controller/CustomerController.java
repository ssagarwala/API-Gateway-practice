package com.tcs.reservationsystem.customerservice.controller;

import com.tcs.reservationsystem.customerservice.model.Customer;
import com.tcs.reservationsystem.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    // Additional CRUD methods
}