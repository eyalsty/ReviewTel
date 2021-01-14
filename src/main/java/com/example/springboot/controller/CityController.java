package com.example.springboot.controller;
import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.GeneralObjWithAvg;
import com.example.springboot.repository.HotelRepository;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // This means that this class is a Controller
 // This means URL's start with /demo (after Application path)
public class CityController {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;



    // adding a list of hotels of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseHotelForAvg")
    public String chooseCity(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "Avg/chooseHotelForAvg";
    }

    // adding a list of hotels of the selected city as an attribute to the model for top 5 hotels
    @PostMapping("/showTopFiveHotelsInCity")
    public String showTopFive(@ModelAttribute City selectedCity, Model model) {
        List<Object[]> topFiveObject = (List<Object[]>) hotelRepository.getTopFive(selectedCity.getId());
        List<GeneralObjWithAvg> topFiveHotels = new ArrayList<>();
        for( Object[] object : topFiveObject)
        {
            GeneralObjWithAvg generalObjWithAvg = new GeneralObjWithAvg();
            generalObjWithAvg.convert(object);
            topFiveHotels.add(generalObjWithAvg);
        }
        model.addAttribute("topFive", topFiveHotels);
        return "TopFive/showTopFiveHotelsInCity";
    }

    // adding a list of hotels of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseHotelForNationality")
    public String chooseHotelForNationality(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "Nationality/chooseHotelForNationality";
    }

    // adding a list of hotels of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseHotelForAddReview")
    public String chooseHotelForAddReview(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "AddReview/chooseHotelForAddReview";
    }
}


