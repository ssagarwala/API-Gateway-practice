package com.tcs.reservationsystem.reservationservice.controller;

import com.tcs.reservationsystem.reservationservice.model.Reservation;
import com.tcs.reservationsystem.reservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @GetMapping("/{id}")
    public Reservation getCustomer(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }
    // Additional CRUD methods
}