package com.sdabbous.learningspring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
