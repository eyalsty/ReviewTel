package com.example.springboot.controller;

import com.example.springboot.model.*;
import com.example.springboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
public class EditReviewController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private GuestsCompositionRepository guestsCompositionRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private TripTypeRepository tripTypeRepository;

    private long currentReviewId;

    @GetMapping("/editReview")
    public String editReview(Model model, @RequestParam String id) {
        currentReviewId = Long.parseLong(id);
        Review _review = new Review();
        model.addAttribute("review", _review);
        try {
            Optional<Review> review = reviewRepository.findById(Long.valueOf(id));
            model.addAttribute("id",id);

            int vacation_length = review.get().getVacation_length();
            model.addAttribute("vacation_length",vacation_length);

            double score = review.get().getScore();
            model.addAttribute("score",score);

            String positive_review = review.get().getPositive_review();
            model.addAttribute("positive_review",positive_review);

            String negative_review = review.get().getNegative_review();
            model.addAttribute("negative_review",negative_review);

            int nationalityId = review.get().getNational_id();
            Optional<Country> nationality = countryRepository.findById(nationalityId);
            model.addAttribute("nationality",nationality.get().getName());

            int guests_id = review.get().getGuests_composition_id();
            Optional<Guests_composition> guests_composition = guestsCompositionRepository.findById(guests_id);
            model.addAttribute("guests_composition",guests_composition.get().getGuests_composition());

            int room_type_id = review.get().getRoom_type_id();
            Optional<Room_type> room_type = roomTypeRepository.findById(room_type_id);
            model.addAttribute("room_type",room_type.get().getRoom_type());

            int trip_type_id = review.get().getTrip_type_id();
            Optional<Trip_type> trip_type = tripTypeRepository.findById(trip_type_id);
            model.addAttribute("trip_type",trip_type.get().getTrip_type());

            int hotel_id = review.get().getHotel_id();
            Optional<Hotel> hotel = hotelRepository.findById(hotel_id);
            model.addAttribute("hotel",hotel.get().getName());

            int city_id = hotel.get().getCity_id();
            Optional<City> city = cityRepository.findById(city_id);
            model.addAttribute("city",city.get().getName());

            int country_id = city.get().getCountry_id();
            Optional<Country> country = countryRepository.findById(country_id);
            model.addAttribute("country",country.get().getName());

            return "editReview";
        }
        catch (Exception ex)
        {
            return "pageNotAvailable";
        }
    }
    @PostMapping("/editReviewSubmitted")
    public RedirectView chooseCountry(@ModelAttribute Review review, Model model) {
        RedirectView redirectView = new RedirectView();
        try {
            Optional<Review> curReview = reviewRepository.findById(currentReviewId);
            curReview.get().setPositive_review(review.getPositive_review());
            curReview.get().setNegative_review(review.getNegative_review());
            reviewRepository.save(curReview.get());
            redirectView.setUrl("http://localhost:8080/pageReviewUpdated");
            return redirectView;
        }
        catch (Exception ex)
        {
            redirectView.setUrl("http://localhost:8080/pageNotAvailable");
            return redirectView;
        }
    }
    @PostMapping("/deleteReview")
    public RedirectView deleteRedirect() {
        reviewRepository.deleteById(currentReviewId);
        //Implement delete

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/pageReviewDeleted/");
        return redirectView;
    }

    @GetMapping("/pageReviewUpdated")
    public String reviewUpdated() {
        return "pageReviewUpdated";
    }
    @GetMapping("/pageReviewDeleted")
    public String reviewDeleted() {
        return "pageReviewDeleted";
    }
}