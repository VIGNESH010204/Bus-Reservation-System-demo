//package com.reservation.controller;
//
//import com.busreservation.model.Bus;
//import com.busreservation.service.ReservationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class BusController {
//
//    @Autowired
//    private ReservationService reservationService;
//
//    @GetMapping("/buses")
//    public List<Bus> getAvailableBuses() {
//        return reservationService.getAvailableBuses();
//    }
//}
