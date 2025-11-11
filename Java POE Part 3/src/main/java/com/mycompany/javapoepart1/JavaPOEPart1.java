package com.mycompany.javapoepart1;

import java.util.Scanner;

public class JavaPOEPart1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName, lastName, username, password, cellPhoneNumber;

        // Capture first name
        do {
            System.out.println("Enter first name (Only letters, no numbers or empty input):");
            firstName = scanner.nextLine();
            if (!firstName.matches("^[A-Za-z]+$")) {
                System.out.println("First name is not valid. Please enter letters only and do not leave it blank.\n");
            }
        } while (!firstName.matches("^[A-Za-z]+$"));
        System.out.println("First name successfully captured.\n");

        // Capture last name
        do {
            System.out.println("Enter last name (Only letters, no numbers or empty input):");
            lastName = scanner.nextLine();
            if (!lastName.matches("^[A-Za-z]+$")) {
                System.out.println("Last name is not valid. Please enter letters only and do not leave it blank.\n");
            }
        } while (!lastName.matches("^[A-Za-z]+$"));
        System.out.println("Last name successfully captured.\n");

        System.out.println("Hello " + firstName + " " + lastName);

        // Create Login object with placeholder values
        Login login = new Login(firstName, lastName, "", "", "");

        // Capture username
        do {
            System.out.println("Enter username (Must contain an underscore and be no more than 5 characters):");
            username = scanner.nextLine();
            if (!login.checkUsername(username)) {
                System.out.println("Username is not correctly formatted. Please ensure it contains an underscore and is no more than five characters.\n");
            }
        } while (!login.checkUsername(username));
        System.out.println("Username successfully captured.\n");

        // Capture password
        do {
            System.out.println("Enter password (At least 8 characters, a capital letter, a number, and a special character):");
            password = scanner.nextLine();
            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted. Please ensure it meets all complexity requirements.\n");
            }
        } while (!login.checkPasswordComplexity(password));
        System.out.println("Password successfully captured.\n");

        // Capture cell phone number
        do {
            System.out.println("Enter cell phone number (Must start with +27 and be followed by 9 digits):");
            cellPhoneNumber = scanner.nextLine();
            if (!login.checkCellPhoneNumber(cellPhoneNumber)) {
                System.out.println("Cell phone number incorrectly formatted. Please ensure it starts with +27 and has 9 digits.\n");
            }
        } while (!login.checkCellPhoneNumber(cellPhoneNumber));
        System.out.println("Cell phone number successfully added.\n");

        // Update Login object with captured values
        login = new Login(firstName, lastName, username, password, cellPhoneNumber);
        System.out.println(login.registerUser());

        // Login attempt
        String enteredUser, enteredPass;
        boolean loginSuccess;

        do {
            System.out.println("\nNow please log in.");

            System.out.print("Enter username: ");
            enteredUser = scanner.nextLine();

            System.out.print("Enter password: ");
            enteredPass = scanner.nextLine();

            loginSuccess = login.loginUser(enteredUser, enteredPass);

            if (!loginSuccess) {
                System.out.println("\nLogin failed! Username or password is incorrect. Please try again.");
            }
        } while (!loginSuccess);

        System.out.println(login.returnLoginStatus(enteredUser, enteredPass));
        
        // Launch Part 2 messaging menu
        scanner.close();

       
    }
}
