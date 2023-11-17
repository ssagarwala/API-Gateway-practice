package com.tcs.reservationsystem.reservationservice.repository;

import com.tcs.reservationsystem.reservationservice.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository <Reservation, String> {

}
