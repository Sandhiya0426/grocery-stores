package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Groceryshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;

    // Other properties and methods...

    public Groceryshop() {}

    public Groceryshop(long id, String name, String location) {
this.id=id;
        this.name = name;
        this.location = location;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
