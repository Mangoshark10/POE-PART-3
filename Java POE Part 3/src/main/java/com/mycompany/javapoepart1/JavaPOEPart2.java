package com.mycompany.javapoepart1;

import javax.swing.JOptionPane;
// HAVE TO RUN THE THIS CLASS INDEPENDTLY SO IT WONT START AT POEPART1    EG RIGHT CLICK THEN RUN FILE
public class JavaPOEPart2 {

    public static void runMessagingMenu() {  
        boolean running = true;
        int messageCount = 0;

        while (running) {
            String option = JOptionPane.showInputDialog(
                "Welcome to QuickChat\n" + "1) Send Messages\n" + "2) Quit"
            );

            switch (option) {
                case "1":
                    String input = JOptionPane.showInputDialog("How many messages would you like to send?");
                    int numMessages = Integer.parseInt(input);

                    for (int i = 1; i <= numMessages; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter recipient number (with +27):");
                        String messageText = JOptionPane.showInputDialog("Enter message text:");

                        Message msg = new Message(recipient, messageText, i);

                        if (msg.checkRecipientCell() == 1 && msg.checkMessageLength() == 1) {
                            String action = msg.SentMessage();

                            switch (action) {
                                case "Send":
                                    JOptionPane.showMessageDialog(null, "Message Sent:\n" + msg.getDetails());
                                    break;
                                case "Store":
                                    msg.storeMessage();
                                    JOptionPane.showMessageDialog(null, "Message Stored:\n" + msg.getDetails());
                                    break;
                                case "Disregard":
                                    JOptionPane.showMessageDialog(null, "Message Disregarded.");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invalid action.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Message not sent due to validation failure.");
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages());
                    break;

                case "2":
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    //NB this added so Part 2 can run independently
    public static void main(String[] args) {
        runMessagingMenu();
    }
}
