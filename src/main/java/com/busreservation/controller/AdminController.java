package com.busreservation.controller;

import com.busreservation.model.Bus;
import com.busreservation.model.Reservation;
import com.busreservation.repository.BusRepository;
import com.busreservation.repository.ReservationRepository;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BusRepository busRepository;
    private final ReservationRepository reservationRepository;

    // ✅ Inject both repositories
    public AdminController(BusRepository busRepository, ReservationRepository reservationRepository) {
        this.busRepository = busRepository;
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/busForm")
    public String showBusForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "admin/bus_form";
    }

    @PostMapping("/addBus")
    public String addBus(@ModelAttribute Bus bus) {
        bus.setAvailableSeats(bus.getTotalSeats());
        busRepository.save(bus);
        return "redirect:/admin/busForm";
    }

    @GetMapping("/offers")
    public String showOffers() {
        return "admin/offers";
    }

    @GetMapping("/reservations")
    public String viewReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "admin/reservations";
    }
    
//    @GetMapping("/dashboard/admin")
//    public String showAdminDashboard() {
//        return "admin/admin_dashboard";
//    }

    @GetMapping("/reservations/api")
    @ResponseBody
    public List<Reservation> getReservationsJson() {
        return reservationRepository.findAll();
    }

}
