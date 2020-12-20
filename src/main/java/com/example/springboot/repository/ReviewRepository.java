package com.example.springboot.repository;

import com.example.springboot.model.Hotel;
import com.example.springboot.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hotelRepository
// CRUD refers Create, Read, Update, Delete

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query(
            value = "SELECT * FROM reviews WHERE hotel_id = :idx",
            nativeQuery = true)
    Collection<Review> getAllReviewsByHotelId(@Param("idx") int idx);
}