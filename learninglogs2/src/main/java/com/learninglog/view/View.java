package com.learninglog.view;
import com.learninglog.controller.EntryController;
import com.learninglog.controller.TopicController;
import com.learninglog.model.Entry;
import com.learninglog.model.Topic;


import java.util.List;
import java.util.Scanner;

public class View {
    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        TopicController topicController = new TopicController();
        EntryController entryController = new EntryController();

        while (true) {
            System.out.println("\n--- Learning Logs Menu ---");
            System.out.println("1. Add New Topic");
            System.out.println("2. View All Topics");
            System.out.println("3. Add Learning Entry");
            System.out.println("4. View All Entries");
            System.out.println("5. View Entries by Topic");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter topic name: ");
                    String topicName = sc.nextLine();
                    try{
                        Topic topic = topicController.addTopic(topicName);
                        System.out.println("Topic added with ID: " + topic.getId());

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("All Topics:");
                    List<Topic> topics = topicController.getAllTopics();
                    if (topics.isEmpty()) {
                        System.out.println("No topics available.");
                    } else {
                        for (Topic t : topics) {
                            System.out.println("ID: " + t.getId() + ", Name: " + t.getName() +
                                    ", Created: " + t.getCreatedDate());
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter Topic ID to add entry: ");
                    int topicId = Integer.parseInt(sc.nextLine());
                    Topic t = topicController.getTopicById(topicId);
                    if (t == null) {
                        System.out.println("Topic not found!");
                        break;
                    }
                    System.out.print("Enter learning entry: ");
                    String content = sc.nextLine();
                    Entry entry = entryController.addEntry(t, content);
                    System.out.println("Entry added with ID: " + entry.getId());
                    break;

                case "4":
                    System.out.println("All Entries:");
                    List<Entry> entries = entryController.getAllEntries();
                    if (entries.isEmpty()) {
                        System.out.println("No entries available.");
                    } else {
                        for (Entry e : entries) {
                            System.out.println("Entry ID: " + e.getId() + ", Topic: " +
                                    e.getTopic().getName() + ", Content: " + e.getContent() +
                                    ", Created: " + e.getCreatedDate());
                        }
                    }
                    break;

                case "5":
                    System.out.print("Enter Topic ID to view entries: ");
                    int tId = Integer.parseInt(sc.nextLine());
                    Topic topicForEntries = topicController.getTopicById(tId);
                    if (topicForEntries == null) {
                        System.out.println("Topic not found!");
                        break;
                    }
                    List<Entry> topicEntries = entryController.getEntriesByTopic(topicForEntries);
                    if (topicEntries.isEmpty()) {
                        System.out.println("No entries for this topic.");
                    } else {
                        for (Entry e : topicEntries) {
                            System.out.println("Entry ID: " + e.getId() + ", Content: " + e.getContent() +
                                    ", Created: " + e.getCreatedDate());
                        }
                    }
                    break;

                case "6":
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}