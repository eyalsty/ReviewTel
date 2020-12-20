package com.example.springboot.repository;

import com.example.springboot.model.City;
import com.example.springboot.model.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hotelRepository
// CRUD refers Create, Read, Update, Delete

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    @Query(
            value = "SELECT name FROM hotels",
            nativeQuery = true)
    Collection<String> getAllHotelsNames();

    @Query(
            value = "SELECT * FROM hotels WHERE city_id = :idx",
            nativeQuery = true)
    Collection<Hotel> getAllHotelsByCityId(@Param("idx") int idx);
}