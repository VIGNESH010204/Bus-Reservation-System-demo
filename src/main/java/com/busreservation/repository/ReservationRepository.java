//package com.busreservation.repository;
//
//import com.busreservation.model.Reservation;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    // Custom query methods (if needed)
//}



package com.busreservation.repository;

import com.busreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
