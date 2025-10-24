//package com.busreservation.controller;
//
//import com.busreservation.model.Bus;
//import com.busreservation.service.ReservationService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class BusController {
//
//    private final ReservationService reservationService;
//
//    public BusController(ReservationService reservationService) {
//        this.reservationService = reservationService;


//package com.busreservation.controller;
//
//import com.busreservation.model.Bus;
//import com.busreservation.service.ReservationService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class BusController {
//
//    private final ReservationService reservationService;
//
//    public BusController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }
//
//    @GetMapping("/buses")
//    public List<Bus> getBuses() {
//        return reservationService.getAvailableBuses();
//    }
//}

//    }
//
//    @GetMapping("/buses")
//    public List<Bus> getBuses() {
//        return reservationService.getAvailableBuses();
//    }
//}



//package com.busreservation.controller;
//
//import com.busreservation.model.Bus;
//import com.busreservation.service.ReservationService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class BusController {
//
//    private final ReservationService reservationService;
//
//    public BusController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }
//
//    @GetMapping("/buses")
//    public List<Bus> getBuses() {
//        return reservationService.getAvailableBuses();
//    }
//}



package com.busreservation.controller;

import com.busreservation.model.Bus;
import com.busreservation.repository.BusRepository;
import com.busreservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // ✅ Changed from @RestController to @Controller to support HTML views
@RequestMapping
public class BusController {

    private final ReservationService reservationService;
    private final BusRepository busRepository;

    public BusController(ReservationService reservationService, BusRepository busRepository) {
        this.reservationService = reservationService;
        this.busRepository = busRepository;
    }

    // ✅ REST endpoint for JSON response
    @GetMapping("/api/buses")
    @ResponseBody
    public List<Bus> getBuses() {
        return reservationService.getAvailableBuses();
    }

    // ✅ HTML form page
    @GetMapping("/busForm")
    public String showBusForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus_form"; // maps to src/main/resources/templates/bus_form.html
    }

    // ✅ Form submission handler
    @PostMapping("/addBus")
    public String addBus(@ModelAttribute Bus bus) {
        busRepository.save(bus);
        return "redirect:/busForm"; // or redirect to a success page
    }
}

