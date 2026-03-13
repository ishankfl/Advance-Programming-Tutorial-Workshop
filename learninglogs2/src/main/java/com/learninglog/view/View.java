package com.learninglog.view;

import com.learninglog.controller.EntryController;
import com.learninglog.controller.TopicController;
import com.learninglog.dao.TopicDAO;
import com.learninglog.model.Entry;
import com.learninglog.model.Topic;

import java.util.List;
import java.util.Scanner;

/**
 * View class (User Interface)
 *
 * This class handles user interaction through the console.
 * It displays menus, takes user input, and calls controller methods
 * to perform actions.
 */
public class View {

    /**
     * Main program loop that displays the menu and handles user choices
     */
    public void startProgram() {

        // Scanner used to read user input from console
        Scanner sc = new Scanner(System.in);

        // Controller objects to handle business logic
        TopicController topicController = new TopicController();
        EntryController entryController = new EntryController();

        // DAO object (currently not needed here but created)
        TopicDAO dao = new TopicDAO();

        // Infinite loop to keep program running until user exits
        while (true) {

            // Display menu options
            System.out.println("\n--- Learning Logs Menu ---");
            System.out.println("1. Add New Topic");
            System.out.println("2. View All Topics");
            System.out.println("3. Add Learning Entry");
            System.out.println("4. View All Entries");
            System.out.println("5. View Entries by Topic");
            System.out.println("6. Exit");

            // Ask user to choose an option
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            // Switch case to handle different menu options
            switch (choice) {

                /**
                 * OPTION 1: Add a new topic
                 */
                case "1":

                    // Ask user to enter topic name
                    System.out.print("Enter topic name: ");
                    String topicName = sc.nextLine();

                    try {

                        // Call controller to add topic
                        Topic topic = topicController.addTopic(topicName);

                        // Display generated topic ID
                        System.out.println("Topic added with ID: " + topic.getId());

                    } catch (Exception e) {

                        // Print error message if something goes wrong
                        System.out.println(e.getMessage());
                    }

                    break;


                /**
                 * OPTION 2: View all topics
                 */
                case "2":

                    try {

                        // Fetch topics from database using controller
                        List<Topic> topicList = topicController.fetchAllTopics();

                        // Loop through topics and display them
                        for (Topic topic : topicList) {

                            System.out.println(
                                    "Id: " + topic.getId() +
                                            "  Name: " + topic.getName()
                            );

                            System.out.println("");
                        }

                    } catch (Exception e) {

                        // Handle possible errors
                        System.out.println("Error fetching topics: " + e.getMessage());
                    }

                    break;


                /**
                 * OPTION 3: Add learning entry
                 * (Not implemented yet)
                 */
                case "3":

                    // Future logic to add learning entry
                    break;


                /**
                 * OPTION 4: View all entries
                 * (Not implemented yet)
                 */
                case "4":

                    // Future logic to view all entries
                    break;


                /**
                 * OPTION 5: View entries by topic
                 * (Not implemented yet)
                 */
                case "5":

                    // Future logic to filter entries by topic
                    break;


                /**
                 * OPTION 6: Exit program
                 */
                case "6":

                    System.out.println("Exiting program...");
                    return;


                /**
                 * If user enters invalid option
                 */
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}