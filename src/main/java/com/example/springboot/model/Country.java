package com.example.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;


    public Country()
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
}
