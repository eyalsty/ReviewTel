package com.example.springboot.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewUI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;

    private String national_name;

    private String positive_review;

    private String negative_review;

    private double score;

    private String trip_type;

    private String guests_composition;

    private String room_type;

    private int vacation_length;

    public ReviewUI(Review review) {
        this.id = review.getId();
        this.positive_review = review.getPositive_review();
        this.negative_review = review.getNegative_review();
        this.score = review.getScore();
        this.trip_type = review.getTrip_type();
        this.vacation_length = review.getVacation_length();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        this.date = df.format(review.getDate());
        //this.national_name = review.getNational_id();
        //this.guests_composition = review.getGuests_composition_id();
        //this.room_type = review.getRoom_type_id();
    }

    public ReviewUI() {

    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getNational_name() {
        return national_name;
    }

    public String getPositive_review() {
        return positive_review;
    }

    public String getNegative_review() {
        return negative_review;
    }

    public double getScore() {
        return score;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public String getGuests_composition() {
        return guests_composition;
    }

    public String getRoom_type() {
        return room_type;
    }

    public int getVacation_length() {
        return vacation_length;
    }

    public void setGuests_composition(String guests_composition) {
        this.guests_composition = guests_composition;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}