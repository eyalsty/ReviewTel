package com.example.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/info")
    public String getInfo(Model model){
//        an attribute used for the navigation bar to determine which tab is currently active
        model.addAttribute("activePage","info");
        return "info";
    }

    @GetMapping("/contact")
    public String getContact(Model model){
//        an attribute used for the navigation bar to determine which tab is currently active
        model.addAttribute("activePage","contact");
        return "contact";
    }
}
