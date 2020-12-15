package com.example.springboot.model;


import javax.persistence.*;

@Entity
//Error of "Cannot resolve table" can be ignored
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private int country_id;


    public City()
    {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String country_name) {
        this.name = country_name;
    }

    public String getName() {
        return name;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCountry_id() {
        return country_id;
    }
}
