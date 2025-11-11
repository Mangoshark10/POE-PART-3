package com.mycompany.javapoepart1;

import java.util.Scanner;

public class JavaPOEPart3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageReport.populateTestData(); //  Load test data into arrays

        boolean running = true;

        while (running) {
            System.out.println("\n — Message Report Menu");
            System.out.println("1) Display all sent messages");
            System.out.println("2) Display longest stored message");
            System.out.println("3) Search message by ID");
            System.out.println("4) Search messages by recipient");
            System.out.println("5) Delete message by hash");
            System.out.println("6) Display full sent message report");
            System.out.println("7) Quit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    MessageReport.displaySentMessages();
                    break;
                case "2":
                    MessageReport.displayLongestMessage();
                    break;
                case "3":
                    System.out.print("Enter message ID (recipient or developer number): ");
                    String id = scanner.nextLine();
                    MessageReport.searchByID(id);
                    break;
                case "4":
                    System.out.print("Enter recipient number: ");
                    String recipient = scanner.nextLine();
                    MessageReport.searchByRecipient(recipient);
                    break;
                case "5":
                    System.out.print("Enter message hash to delete: ");
                    String hash = scanner.nextLine();
                    MessageReport.deleteByHash(hash);
                    break;
                case "6":
                    MessageReport.displayReport();
                    break;
                case "7":
                    running = false;
                    System.out.println(" Exiting Message Report Menu. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
