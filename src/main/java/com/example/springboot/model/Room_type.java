package com.example.springboot.model;

import javax.persistence.*;

@Entity
//Error of "Cannot resolve table" can be ignored
@Table(name = "room_types")
public class Room_type {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String room_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}
