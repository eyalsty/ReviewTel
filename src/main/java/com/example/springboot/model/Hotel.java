package com.example.springboot.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
//Error of "Cannot resolve table" can be ignored
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;

    private String address;

    private int city_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCity_id() {
        return city_id;
    }
}