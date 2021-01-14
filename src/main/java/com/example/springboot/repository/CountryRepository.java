package com.example.springboot.repository;
import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.springboot.model.Country;

import java.util.Collection;

public interface CountryRepository extends CrudRepository<Country, Integer>{
    @Query(
            value = "SELECT * FROM countries LEFT JOIN cities ON countries.id = cities.country_id WHERE cities.country_id is not NULL ORDER BY countries.name ASC",
            nativeQuery = true)
    Collection<Country> allCountriesWithReviews();
}
