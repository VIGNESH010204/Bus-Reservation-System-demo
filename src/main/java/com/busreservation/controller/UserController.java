//package com.busreservation.controller;
//
//import com.busreservation.model.User;
//import com.busreservation.service.UserService;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//}


//package com.busreservation.controller;
//
//import com.busreservation.model.Bus;
//import com.busreservation.model.Reservation;
//import com.busreservation.repository.BusRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    private final BusRepository busRepository;
//
//    public UserController(BusRepository busRepository) {
//        this.busRepository = busRepository;
//    }
//
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "user/dashboard";
//    }
//
//    @GetMapping("/availableBuses")
//    public String availableBuses(Model model) {
//        model.addAttribute("buses", busRepository.findAll());
//        return "user/available_buses";
//    }
//
//    @GetMapping("/reserve")
//    public String showReservationForm(Model model) {
//        model.addAttribute("buses", busRepository.findAll());
//        return "user/reserve_ticket";
//    }
//
//    @PostMapping("/reserve")
//    public String reserveTicket(@RequestParam Long busId,
//                                @RequestParam String passengerName,
//                                @RequestParam int seatCount) {
//        Bus bus = busRepository.findById(busId).orElse(null);
//        if (bus != null && bus.getAvailableSeats() >= seatCount) {
//            bus.setAvailableSeats(bus.getAvailableSeats() - seatCount);
//            busRepository.save(bus);
//
//            Reservation reservation = new Reservation(passengerName, bus, LocalDateTime.now(), seatCount);
//            reservationRepository.save(reservation);
//        }
//        return "redirect:/user/dashboard";
//    }
//
//}


package com.busreservation.controller;

import com.busreservation.model.Bus;
import com.busreservation.model.Passenger;
import com.busreservation.model.Reservation;
import com.busreservation.model.User;
import com.busreservation.repository.BusRepository;
import com.busreservation.repository.PassengerRepository;
import com.busreservation.repository.ReservationRepository;
import com.busreservation.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final BusRepository busRepository;
    private final ReservationRepository reservationRepository;
    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;

    public UserController(BusRepository busRepository,
                          ReservationRepository reservationRepository,
                          PassengerRepository passengerRepository,
                          UserRepository userRepository) {
        this.busRepository = busRepository;
        this.reservationRepository = reservationRepository;
        this.passengerRepository = passengerRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ UserController loaded");
    }

    // ✅ Dashboard with username
    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "user/dashboard";
    }

    // ✅ View available buses
    @GetMapping("/availableBuses")
    public String availableBuses(Model model) {
        model.addAttribute("buses", busRepository.findAll());
        return "user/available_buses";
    }

    // ✅ Show reservation form with user's passengers
    @GetMapping("/reserve")
    public String showReservationForm(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByName(username)
                      .orElseThrow(() -> new RuntimeException("User not found"));

        List<Passenger> userPassengers = passengerRepository.findByUser(user);

        model.addAttribute("buses", busRepository.findAll());
        model.addAttribute("passengers", userPassengers);
        model.addAttribute("username", username);

        return "user/reserve_ticket";
    }

    // ✅ Show passenger registration form
    @GetMapping("/addPassenger")
    public String showPassengerForm(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("passenger", new Passenger());
        model.addAttribute("username", username);
        System.out.println("✅ Add Passenger form loaded for: " + username);
        return "user/add_passenger";
    }

    // ✅ Save passenger linked to logged-in user
    @PostMapping("/addPassenger")
    public String savePassenger(@ModelAttribute Passenger passenger, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByName(username)
                      .orElseThrow(() -> new RuntimeException("User not found"));

        passenger.setUser(user);
        passengerRepository.save(passenger);

        System.out.println("✅ Passenger saved for user: " + username);
        return "redirect:/user/reserve";
    }

    // ✅ Reserve ticket
    @PostMapping("/reserve")
    public String reserveTicket(@RequestParam Long busId,
                                @RequestParam Long passengerId,
                                @RequestParam int seatCount,
                                Principal principal) {

        String username = principal.getName();
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        if (bus.getAvailableSeats() < seatCount) {
            throw new IllegalArgumentException("Not enough seats available");
        }

        bus.setAvailableSeats(bus.getAvailableSeats() - seatCount);
        busRepository.save(bus);

        Reservation reservation = new Reservation(passenger.getName(), bus, seatCount);
        reservation.setPassenger(passenger);
        reservationRepository.save(reservation);

        System.out.println("✅ Reservation confirmed for user: " + username);
        return "redirect:/user/reservations";
    }

    // ✅ View all reservations
    @GetMapping("/reservations")
    public String viewReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "user/reservations";
    }
}
