package com.learninglog.learninglogproject.topic.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String namel;
    private int userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Topic(){}

    public Topic(int id, String namel, int userId, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.namel = namel;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
