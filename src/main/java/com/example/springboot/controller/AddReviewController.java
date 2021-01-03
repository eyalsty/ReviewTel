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


//TODO REDUNDANT

@Controller // This means that this class is a Controller
public class AddReviewController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;


   /* @GetMapping("/addReview")
    public String chooseCountryForAvg(Model model) {
        model.addAttribute("activePage","addReview");
        Country country = new Country();
        model.addAttribute("country", country);
        List<Country> countryListWithHotels = (List<Country>) countryRepository.allCountriesWithReviews();
        //List<Country> countryList = (List<Country>) countryRepository.findAll();
        model.addAttribute("countryListWithHotels", countryListWithHotels);
        City city = new City();
        model.addAttribute("city", city);

        List<City> cityList = (List<City>) cityRepository.findAll();
        model.addAttribute("cityList", cityList);
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.findAll();
        model.addAttribute("hotelList", hotelList);

        List<Country> addCountryList = (List<Country>) countryRepository.findAll();
        //List<Country> countryList = (List<Country>) countryRepository.findAll();
        model.addAttribute("allCountryList", addCountryList);

        Review review = new Review();
        model.addAttribute("review", review);
        ReviewUI reviewUI = new ReviewUI();
        model.addAttribute("reviewUI", reviewUI);
        return "AddReview/addReview";
    }
    */


}