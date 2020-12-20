package com.example.springboot.repository;

import com.example.springboot.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CityRepository extends CrudRepository<City, Integer>{
    @Query(
            value = "SELECT name FROM cities",
            nativeQuery = true)
    Collection<String> getAllCities();

    @Query(
            value = "SELECT * FROM cities WHERE country_id = :idx",
            nativeQuery = true)
    Collection<City> getAllCitiesByCountryId(@Param("idx") int idx);
}
