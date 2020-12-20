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

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
public class ReviewController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    private Optional<Review> r;

    @GetMapping("/addReview")
    public String addReview(Model model) {
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
        return "addReview";
    }

    @GetMapping("/chooseReviewToEdit")
    public String chooseReviewToEdit(Model model) {
        Review review = new Review();
        model.addAttribute("review", review);
        return "chooseReviewToEdit";
    }
    @PostMapping("/addReviewSubmitted")
    public String addReviewSubmitted(@ModelAttribute Review review, Model model) {
        List<Review> reviews = (List<Review>)reviewRepository.findAll();
        int id = reviews.get(reviews.size()-1).getId();
        review.setId(id+1);
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        review.setDate(date);
        review.setGuests_composition(review.getGuests_composition().replace('_',' '));
        reviewRepository.save(review);
        return "reviewSubmitted";
    }

    @PostMapping("/reviewForEditInserted")
    public String reviewForEditInserted(@ModelAttribute Review review, Model model) {
        r = Optional.ofNullable(reviewRepository.findById(review.getId()).orElse(null));
        try {
            if (r.get() != null) {
                Optional<Hotel> hotel = Optional.ofNullable(hotelRepository.findById(r.get().getHotel_id())).orElse(null);
                Optional<City> city = Optional.ofNullable(cityRepository.findById(hotel.get().getCity_id())).orElse(null);
                Optional<Country> country = Optional.ofNullable(countryRepository.findById(city.get().getCountry_id())).orElse(null);
                if (hotel.get() != null) {
                    model.addAttribute("id", r.get().getId());
                    model.addAttribute("country", country.get().getName());
                    model.addAttribute("city", city.get().getName());
                    model.addAttribute("hotel", hotel.get().getName());
                    model.addAttribute("nationality", r.get().getNational_id());
                    model.addAttribute("guests_composition", r.get().getGuests_composition());
                    model.addAttribute("room_type", r.get().getRoom_type());
                    model.addAttribute("trip_type", r.get().getTrip_type());
                    model.addAttribute("vacation_length", r.get().getVacation_length());
                    model.addAttribute("score", r.get().getScore());
                    model.addAttribute("positive_review", r.get().getPositive_review());
                    model.addAttribute("negative_review", r.get().getNegative_review());
                }
                return "editReview";
            }
        } catch (Exception exception) {
            return "noReviewFound";
        }
        return "noReviewFound";
    }
}