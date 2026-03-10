package com.learninglog.model;

import java.sql.Timestamp;

public class Entry {
    private int id;
    private Topic topic;
    private String content;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    // Constructor
    public Entry(int id, Topic topic, String content, Timestamp createdDate, Timestamp updatedDate) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        // Use passed timestamps if provided, otherwise use current time
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.updatedDate = new Timestamp(System.currentTimeMillis());
    }

    // Convenience constructor without timestamps
    public Entry(int id, Topic topic, String content) {
        this(id, topic, content, null, null);
    }

    // Getters
    public int getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    // Setters
    public void setContent(String content) {
        this.content = content;
        this.updatedDate = new Timestamp(System.currentTimeMillis());
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
        this.updatedDate = new Timestamp(System.currentTimeMillis());
    }
}
