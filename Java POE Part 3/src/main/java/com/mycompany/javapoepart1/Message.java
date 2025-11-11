package com.mycompany.javapoepart1;

import javax.swing.JOptionPane;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class Message {
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag;
    private int messageNumber;
    private static int totalMessages = 0;

    // Constructor for Part 2 (no flag)
    public Message(String recipient, String messageText, int messageNumber) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = messageNumber;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash(messageID, messageNumber, messageText);
    }

    // Constructor for Part 3 (includes flag)
    public Message(String recipient, String messageText, int messageNumber, String flag) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = messageNumber;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash(messageID, messageNumber, messageText);
        this.flag = flag;
    }

    // Getters for Part 3 compatibility
    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getFlag() {
        return flag;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String generateHash() {
        return messageHash;
    }

    private String generateMessageID() {
        Random rand = new Random();
        return String.format("%010d", rand.nextInt(1_000_000_000));
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public int checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12 && recipient.substring(3).matches("\\d{9}")) {
            System.out.println("Cell phone number successfully captured.");
            return 1;
        } else {
            System.out.println("Cell phone number is incorrectly formatted.");
            return 0;
        }
    }

    public int checkMessageLength() {
        if (messageText.length() <= 250) {
            System.out.println("Message ready to send.");
            return 1;
        } else {
            int excess = messageText.length() - 250;
            System.out.println("Message exceeds 250 characters by " + excess + ". Please reduce size.");
            return 0;
        }
    }

    public String createMessageHash(String id, int num, String msg) {
        String[] words = msg.trim().split(" ");
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;
        String hash = id.substring(0, 2) + ":" + String.format("%02d", num) + first + last;
        return hash.toUpperCase();
    }

    public String SentMessage() {
        String input = JOptionPane.showInputDialog("Choose:\n1) Send Message\n2) Disregard Message\n3) Store Message");
        switch (input) {
            case "1":
                totalMessages++;
                return "Send";
            case "2":
                return "Disregard";
            case "3":
                return "Store";
            default:
                return "Invalid";
        }
    }

    public String getDetails() {
        return "Message ID: " + messageID +
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    public void storeMessage() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("storedMessage.json", true);
            gson.toJson(this, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
}
