package com.example.springboot.model;

import javax.persistence.*;

@Entity
//Error of "Cannot resolve table" can be ignored
@Table(name = "trip_types")
public class Trip_type {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String trip_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setTrip_type(String room_type) {
        this.trip_type = room_type;
    }
}
