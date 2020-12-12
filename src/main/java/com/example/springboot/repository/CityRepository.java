package com.example.springboot.repository;

import com.example.springboot.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CityRepository extends CrudRepository<City, Integer>{
    @Query(
            value = "SELECT name FROM city",
            nativeQuery = true)
    Collection<String> getAllCities();

    @Query(
            value = "SELECT name FROM city WHERE country_id = :idx",
            nativeQuery = true)
    Collection<String> getAllCitiesByCountryId(@Param("idx") int idx);
}
