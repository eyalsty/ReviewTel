package com.example.springboot.repository;
import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.springboot.model.Country;

import java.util.Collection;

public interface CountryRepository extends CrudRepository<Country, Integer>{
    @Query(
            value = "SELECT * FROM country LEFT JOIN city ON country.id = country_id WHERE city.country_id is not NULL ",
            nativeQuery = true)
    Collection<Country> allCountriesWithReviews();

    @Query(
            value = "SELECT name FROM country",
            nativeQuery = true)
    Collection<String> getAllCountries();
}
