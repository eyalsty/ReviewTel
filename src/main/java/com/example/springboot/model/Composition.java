package com.example.springboot.model;

import javax.persistence.*;


@Entity
//Error of "Cannot resolve table" can be ignored
@Table(name = "compositions")
public class Composition {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String guests_composition;
    private String room_type;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public String getGuestsComposition() {
        return guests_composition;
    }

    public void setGuestsComposition(String country_name) {
        this.guests_composition = country_name;
    }

    public String getRoomType() {
        return room_type;
    }
}
