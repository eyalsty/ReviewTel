package com.example.springboot.controller;

import com.example.springboot.model.Review;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//TODO REDUNDANT

@Controller // This means that this class is a Controller
@RequestMapping(path = "/index")
public class ReviewController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ReviewRepository reviewRepository;

    @GetMapping(path = "/allReviews")
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        System.out.println("HII");
        // This returns a JSON or XML with the users
        return reviewRepository.findAll();
    }
}