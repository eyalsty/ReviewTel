package com.example.springboot.repository;

import com.example.springboot.model.Review;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called hotelRepository
// CRUD refers Create, Read, Update, Delete

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}