package com.example.springboot.controller;

import com.example.springboot.model.*;
import com.example.springboot.repository.CityRepository;
import com.example.springboot.repository.CountryRepository;
import com.example.springboot.repository.HotelRepository;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// This means URL's start with /demo (after Application path)
public class LoginController {

    // if user tries to login
    @PostMapping("/login")
    public String login(Model model, String password) {
        Admin admin = Admin.getInstance();
        model.addAttribute("errorText", "wrong password was entered.");
        return admin.setConnection(password) ? "adminHomePage" : "index";
    }

    // if user tries go to home page
    @GetMapping("/")
    public String welcome(Model model) {
        Admin admin = Admin.getInstance();
        if (admin.isConnected()) {
            return "adminHomePage";
        }
        return "index";
    }
}