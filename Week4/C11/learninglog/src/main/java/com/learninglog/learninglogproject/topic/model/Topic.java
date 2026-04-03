package com.learninglog.learninglogproject.topic.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String name;
    private int userId;
    private Timestamp createdAt;

    public Topic(Timestamp createdAt, int userId, String name, int id) {
        this.createdAt = createdAt;
        this.userId = userId;
        this.name = name;
        this.id = id;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
