package com.learninglog.learninglogproject.topic.model;

import java.sql.Timestamp;

public class Topic {
    private  int id;
    private String  name;
    private  int user_id;
    private Timestamp createdAt;

    public  Topic (){}

    public Topic(int id, String name, int user_id, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.createdAt = createdAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
