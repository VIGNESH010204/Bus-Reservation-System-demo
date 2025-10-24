package com.busreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin_login";
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "user_login";
    }
}

