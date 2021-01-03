package com.example.springboot.controller;
import com.example.springboot.model.City;
import com.example.springboot.model.Country;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.Review;
import com.example.springboot.repository.CityRepository;
import com.example.springboot.repository.CountryRepository;
import com.example.springboot.repository.HotelRepository;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO REDUNDANT

@RestController

 // This means URL's start with /demo (after Application path)
public class LoginController {



    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}