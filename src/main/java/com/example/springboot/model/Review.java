package com.example.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
//Error of "Cannot resolve table" can be ignored
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private java.sql.Date date;

    private Integer hotel_id;

    private Integer national_id;

    private String positive_review;

    private String negative_review;

    private double score;

    private Integer trip_type_id;

    private Integer guests_composition_id;

    private Integer room_type_id;

    private Integer vacation_length;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setNational_id(int national_id) {
        this.national_id = national_id;
    }

    public int getNational_id() {
        return national_id;
    }

    public void setPositive_review(String positive_review) {
        this.positive_review = positive_review;
    }

    public String getPositive_review() {
        return positive_review;
    }

    public void setNegative_review(String negative_review) {
        this.negative_review = negative_review;
    }

    public String getNegative_review() {
        return negative_review;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setTrip_type_id(Integer trip_type_id) {
        this.trip_type_id = trip_type_id;
    }

    public Integer getTrip_type_id() {
        return trip_type_id;
    }

    public void setVacation_length(int vacation_length) {
        this.vacation_length = vacation_length;
    }

    public int getVacation_length() {
        return vacation_length;
    }

    public Integer getGuests_composition_id() {
        return guests_composition_id;
    }

    public void setGuests_composition_id(Integer guests_composition_id) {
        this.guests_composition_id = guests_composition_id;
    }

    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }
}