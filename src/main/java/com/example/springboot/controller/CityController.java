package com.example.springboot.controller;
import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.HotelAvg;
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




    @PostMapping("/chooseHotelForAvg")
    public String chooseCity(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "Avg/chooseHotelForAvg";
    }
    @PostMapping("/showTopFiveHotelsInCity")
    public String showTopFive(@ModelAttribute City selectedCity, Model model) {
        List<Object[]> topFiveObject = (List<Object[]>) hotelRepository.getTopFive(selectedCity.getId());
        List<HotelAvg> topFiveHotels = new ArrayList<>();
        for( Object[] object : topFiveObject)
        {
            HotelAvg hotelAvg = new HotelAvg();
            hotelAvg.convert(object);
            topFiveHotels.add(hotelAvg);
        }

        model.addAttribute("topFive", topFiveHotels);
        return "TopFive/showTopFiveHotelsInCity";
    }

    @PostMapping("/chooseHotelForNationality")
    public String chooseHotelForNationality(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "Nationality/chooseHotelForNationality";
    }

    @PostMapping("/chooseHotelForAddReview")
    public String chooseHotelForAddReview(@ModelAttribute City selectedCity, Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);

        List<Hotel> hotelList = (List<Hotel>) hotelRepository.getAllHotelsByCityId(selectedCity.getId());
        model.addAttribute("hotelList", hotelList);
        return "AddReview/chooseHotelForAddReview";
    }
}


