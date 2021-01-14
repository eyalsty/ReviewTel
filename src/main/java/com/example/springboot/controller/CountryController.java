package com.example.springboot.controller;
import com.example.springboot.model.City;
import com.example.springboot.model.Country;
import com.example.springboot.repository.CityRepository;
import com.example.springboot.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // This means that this class is a Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;

    // adding a list of countries as an attribute to the model for
    // getting it at the returned html page
    @GetMapping("/chooseCountryForAvg")
    public String chooseCountryForAvg(Model model) {
        model.addAttribute("activePage","chooseCountryForAvg");
        Country country = new Country();
        model.addAttribute("country", country);
        List<Country> countryList = (List<Country>) countryRepository.allCountriesWithReviews();
        model.addAttribute("countryList", countryList);
        return "Avg/chooseCountryForAvg";
    }

    // adding a list of cities of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseCityForAvg")
    public String chooseCountry(@ModelAttribute Country selectedCountry, Model model) {
        City city = new City();
        model.addAttribute("city", city);

        List<City> cityList = (List<City>) cityRepository.getAllCitiesByCountryId(selectedCountry.getId());
        model.addAttribute("cityList", cityList);
        return "Avg/chooseCityForAvg";
    }

    // adding a list of countries as an attribute to the model for
    // getting it at the returned html page
    @GetMapping("/chooseCountryForTopFive")
    public String chooseCountryForTopFive(Model model) {
        model.addAttribute("activePage","chooseCountryForTopFive");
        Country country = new Country();
        model.addAttribute("country", country);
        List<Country> countryList = (List<Country>) countryRepository.allCountriesWithReviews();
        model.addAttribute("countryList", countryList);
        return "TopFive/chooseCountryForTopFive";
    }

    // adding a list of cities of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseCityForTopFive")
    public String chooseCityForTopFive(@ModelAttribute Country selectedCountry, Model model) {
        City city = new City();
        model.addAttribute("city", city);

        List<City> cityList = (List<City>) cityRepository.getAllCitiesByCountryId(selectedCountry.getId());
        model.addAttribute("cityList", cityList);
        return "TopFive/chooseCityForTopFive";
    }

    // adding a list of countries as an attribute to the model for
    // getting it at the returned html page
    @GetMapping("/chooseCountryForNationality")
    public String chooseCountryNationality(Model model) {
        model.addAttribute("activePage","chooseCountryForNationality");
        Country country = new Country();
        model.addAttribute("country", country);
        List<Country> countryList = (List<Country>) countryRepository.allCountriesWithReviews();
        model.addAttribute("countryList", countryList);
        return "Nationality/chooseCountryForNationality";
    }

    // adding a list of cities of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseCityForNationality")
    public String chooseCityForNationality(@ModelAttribute Country selectedCountry, Model model) {
        City city = new City();
        model.addAttribute("city", city);

        List<City> cityList = (List<City>) cityRepository.getAllCitiesByCountryId(selectedCountry.getId());
        model.addAttribute("cityList", cityList);
        return "Nationality/chooseCityForNationality";
    }

    // adding a list of countries as an attribute to the model for
    // getting it at the returned html page
    @GetMapping("/chooseCountryForAddReview")
    public String chooseCountryForAddReview(Model model) {
        model.addAttribute("activePage","chooseCountryForAddReview");
        Country country = new Country();
        model.addAttribute("country", country);
        List<Country> countryList = (List<Country>) countryRepository.allCountriesWithReviews();
        model.addAttribute("countryList", countryList);
        return "AddReview/chooseCountryForAddReview";
    }

    // adding a list of cities of the selected city as an attribute to the model for
    // getting it at the returned html page
    @PostMapping("/chooseCityForAddReview")
    public String chooseCityForAddReview(@ModelAttribute Country selectedCountry, Model model) {
        City city = new City();
        model.addAttribute("city", city);

        List<City> cityList = (List<City>) cityRepository.getAllCitiesByCountryId(selectedCountry.getId());
        model.addAttribute("cityList", cityList);
        return "AddReview/chooseCityForAddReview";
    }
}