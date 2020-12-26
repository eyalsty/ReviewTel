package com.example.springboot.model;

import javax.persistence.*;


@Entity
//Error of "Cannot resolve table" can be ignored
@Table(name = "guests_compositions")
public class Guests_composition {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String guests_composition;
    private String room_type;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public String getRoomType() {
        return room_type;
    }

    public String getGuests_composition() {
        return guests_composition;
    }

    public void setGuests_composition(String guests_composition) {
        this.guests_composition = guests_composition;
    }
}
