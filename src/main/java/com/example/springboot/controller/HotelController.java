package com.example.springboot.controller;

import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.HotelAvg;
import com.example.springboot.model.Review;
import com.example.springboot.repository.CityRepository;
import com.example.springboot.repository.CountryRepository;
import com.example.springboot.repository.HotelRepository;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // This means that this class is a Controller
public class HotelController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CountryRepository countryRepository;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data

    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewHotel(@RequestParam int id, @RequestParam String name
            , @RequestParam String address, @RequestParam int cityId) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setCity_id(cityId);
        hotelRepository.save(hotel);
        return "Saved new hotel";
    }

    @GetMapping(path = "/allHotels")
    public @ResponseBody
    Iterable<Hotel> getAllHotels() {
        // This returns a JSON or XML with the users
        return hotelRepository.findAll();
    }
    @GetMapping(path = "/allHotelsNames")
    public @ResponseBody
    Iterable<String> getAllHotelsNames() {
        // This returns a JSON or XML with the users
        return hotelRepository.getAllHotelsNames();
    }

    @PostMapping("/showReviewsWithAvg")
    public String chooseHotel(@ModelAttribute Hotel selectedHotel, Model model) {
        List<Review> reviewsList = (List<Review>) reviewRepository.getAllReviewsByHotelId(selectedHotel.getId());
        model.addAttribute("reviews", reviewsList);
        double avg = reviewRepository.getAverageOfHotel(selectedHotel.getId());
        avg = avg*1000;
        int temp = (int)avg;
        avg = (double)temp/1000;
        String average = "Average Is: " + Double.toString(avg);
        model.addAttribute("avg", average);
        return "showReviewsWithAvg";
    }


    @PostMapping("/showHotelByNationality")
    public String showHotelByNationality(@ModelAttribute City selectedCity, Model model) {
        List<Object[]> topFiveObject = (List<Object[]>) hotelRepository.getByNationality(selectedCity.getId());
        List<HotelAvg> nationalitiesAvg = new ArrayList<>();
        for( Object[] object : topFiveObject)
        {
            HotelAvg hotelAvg = new HotelAvg();
            hotelAvg.convert(object);
            nationalitiesAvg.add(hotelAvg);
        }

        model.addAttribute("nationalities", nationalitiesAvg);
        return "showHotelByNationality";
    }
}