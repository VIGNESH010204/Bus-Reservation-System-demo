package com.busreservation.repository;

import com.busreservation.model.Passenger;
import com.busreservation.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	List<Passenger> findByUser(User user);

}
