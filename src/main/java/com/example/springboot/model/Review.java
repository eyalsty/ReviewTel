package com.example.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Review {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private java.sql.Date date;

    private int hotel_id;

    private int national_id;

    private String positive_review;

    private String negative_review;

    private double score;

    private String trip_type;

    private String guests_composition;

    private String room_type;

    private int vacation_length;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setTrip_type(String trip_type) {
        this.trip_type = trip_type;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setVacation_length(int vacation_length) {
        this.vacation_length = vacation_length;
    }

    public int getVacation_length() {
        return vacation_length;
    }

    public void setGuests_composition(String guests_composition) {
        this.guests_composition = guests_composition;
    }

    public String getGuests_composition() {
        return guests_composition;
    }
}