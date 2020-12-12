package com.example.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.springboot.model.Country;

import java.util.Collection;

public interface CountryRepository extends CrudRepository<Country, Integer>{
    @Query(
            value = "SELECT id,name FROM country",
            nativeQuery = true)
    Collection<Country> allCountries();

    @Query(
            value = "SELECT name FROM country",
            nativeQuery = true)
    Collection<String> getAllCountries();
}
