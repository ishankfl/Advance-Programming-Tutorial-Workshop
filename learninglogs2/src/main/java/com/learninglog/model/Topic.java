package com.learninglog.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String name;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    // Constructor
    public Topic(int id, String name, Timestamp createdDate, Timestamp updatedDate) {
        this.id = id;
        this.name = name;
        // Use passed timestamps if provided; otherwise, use current time
        this.createdDate =  new Timestamp(System.currentTimeMillis());
        this.updatedDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
        this.updatedDate = new Timestamp(System.currentTimeMillis());
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
