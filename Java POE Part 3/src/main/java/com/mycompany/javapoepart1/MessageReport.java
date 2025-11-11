package com.mycompany.javapoepart1;

import java.util.ArrayList;

public class MessageReport {

    public static ArrayList<Message> sentMessages = new ArrayList<>();
    public static ArrayList<Message> storedMessages = new ArrayList<>();
    public static ArrayList<Message> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();

    // Populate arrays with rubric test data
    public static void populateTestData() {
        ArrayList<Message> allMessages = new ArrayList<>();

        allMessages.add(new Message("+27834557896", "Did you get the cake?", 1, "Sent"));
        allMessages.add(new Message("+27388884567", "Where are you? You are late! I have asked you to be on time.", 2, "Stored"));
        allMessages.add(new Message("+2738444567", "Yohooooo, I am at your gate.", 3, "Disregard"));
        allMessages.add(new Message("0838884567", "It is dinner time !", 4, "Stored"));
        allMessages.add(new Message("+27388884567", "Ok, I am leaving without you.", 5, "Stored"));

        for (Message msg : allMessages) {
            switch (msg.getFlag()) {
                case "Sent":
                    sentMessages.add(msg);
                    break;
                case "Stored":
                    storedMessages.add(msg);
                    break;
                case "Disregard":
                    disregardedMessages.add(msg);
                    break;
            }
            messageHashes.add(msg.generateHash());
            messageIDs.add(msg.getRecipient());
        }
    }

    // Display all sent messages
    public static void displaySentMessages() {
        System.out.println("\nSent Messages:");
        for (Message msg : sentMessages) {
            System.out.println("To: " + msg.getRecipient() + " | Message: " + msg.getMessageText());
        }
    }

    // Display longest stored message
    public static void displayLongestMessage() {
        Message longest = null;
        for (Message msg : storedMessages) {
            if (longest == null || msg.getMessageText().length() > longest.getMessageText().length()) {
                longest = msg;
            }
        }
        if (longest != null) {
            System.out.println("\nLongest Stored Message:");
            System.out.println(longest.getMessageText());
        } else {
            System.out.println("No stored messages found.");
        }
    }

    // Search by message ID
    public static void searchByID(String id) {
        for (Message msg : storedMessages) {
            if (msg.getRecipient().equals(id)) {
                System.out.println("\nMessage Found:");
                System.out.println("To: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    // Search all messages sent to a recipient
    public static void searchByRecipient(String recipient) {
        System.out.println("\nMessages to " + recipient + ":");
        boolean found = false;
        for (Message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                System.out.println("- " + msg.getMessageText());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }

    // Delete message using hash
    public static void deleteByHash(String hash) {
        for (Message msg : storedMessages) {
            if (msg.generateHash().equals(hash)) {
                storedMessages.remove(msg);
                System.out.println("\n Message deleted:");
                System.out.println(msg.getMessageText());
                return;
            }
        }
        System.out.println("Hash not found.");
    }

    // Display full report of sent messages
    public static void displayReport() {
        System.out.println("\n Sent Message Report:");
        for (Message msg : sentMessages) {
            System.out.println("Message #" + msg.getMessageNumber());
            System.out.println("Hash: " + msg.generateHash());
            System.out.println("To: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessageText() + "\n");
        }
    }
}
