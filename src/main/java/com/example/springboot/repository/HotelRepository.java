package com.example.springboot.repository;

import com.example.springboot.model.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hotelRepository
// CRUD refers Create, Read, Update, Delete

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    @Query(
            value = "SELECT name FROM hotel",
            nativeQuery = true)
    Collection<String> getAllHotelsNames();
}