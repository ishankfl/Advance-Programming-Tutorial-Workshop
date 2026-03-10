package com.learninglog.controller;

import com.learninglog.model.Entry;
import com.learninglog.model.Topic;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EntryController {
    private List<Entry> entries = new ArrayList<>();
    private int entryIdCounter = 1;

    public Entry addEntry(Topic topic, String content) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        Timestamp updatedDate = createdDate;
        Entry entry = new Entry(entryIdCounter++, topic, content, createdDate, updatedDate);
        entries.add(entry);
        return entry;
    }

    public List<Entry> getAllEntries() {
        return entries;
    }

    public List<Entry> getEntriesByTopic(Topic topic) {
        List<Entry> result = new ArrayList<>();
        for (Entry e : entries) {
            if (e.getTopic().getId() == topic.getId()) {
                result.add(e);
            }
        }
        return result;
    }
}