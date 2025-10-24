//package com.busreservation.service;
//
//import com.busreservation.model.Bus;
//import com.busreservation.model.Reservation;
//import com.busreservation.repository.ReservationRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service  // ✅ Makes this class a Spring-managed service
//public class ReservationService {
//
//    private final ReservationRepository reservationRepository;
//
//    // Constructor-based dependency injection
//    public ReservationService(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    // ✅ Get all reservations
//    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
//    }
//
//    // ✅ Save a new reservation
//    public Reservation saveReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }
//
//    // ✅ Placeholder for future bus logic (can be implemented later)
//    public List<Bus> getAvailableBuses() {
//        // TODO: Implement logic to fetch available buses
//        return null;
//    }
//}
//

//
//package com.busreservation.service;
//
//import com.busreservation.model.Bus;
//import com.busreservation.model.Reservation;
//import com.busreservation.repository.ReservationRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ReservationService {
//
//    private final ReservationRepository reservationRepository;
//
//    // Constructor-based dependency injection
//    public ReservationService(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }
//
//    // 🔹 Fetch all reservations
//    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
//    }
//
//    // 🔹 Save a new reservation
//    public Reservation saveReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }
//
//    // 🔹 Placeholder for available buses (to be implemented)
//    public List<Bus> getAvailableBuses() {
//        // TODO: Implement logic to fetch available buses
//        return List.of(); // returning empty list for now
//    }
//}
//

package com.busreservation.service;

import com.busreservation.model.Bus;
import com.busreservation.model.Reservation;
import com.busreservation.repository.BusRepository;
import com.busreservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BusRepository busRepository;

    public ReservationService(ReservationRepository reservationRepository, BusRepository busRepository) {
        this.reservationRepository = reservationRepository;
        this.busRepository = busRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Bus> getAvailableBuses() {
        return busRepository.findAll();
    }
}

