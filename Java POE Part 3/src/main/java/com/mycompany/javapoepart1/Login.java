
package com.mycompany.javapoepart1;


    import java.util.regex.Pattern;
    import java.util.regex.Matcher;
            
            
            
public class Login {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;


    public Login( String firstName, String lastName,String username, String password, String cellPhoneNumber) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        
    }

       public boolean checkFirstName(String firstName) { 
       return firstName.matches("^[A-Za-z]+$");
   }

   public boolean checkLastName(String lastName) {
       return lastName.matches("^[A-Za-z]+$");
   }

    // Check username that must contain _ and be = 5
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;

    }
    //Chhecking user
    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
        
        //I used AI here at(    ^?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$     )

    }

    // Must check the requirements after +27 must be 9 numbers
   public boolean checkCellPhoneNumber(String cellPhoneNumber) {
    // Must start with +27 and be followed by exactly 9 digits
    return cellPhoneNumber.matches("\\+27\\d{9}");
}


        
    
    // Registration method with correct feedback mesages
    public String registerUser() {
    boolean isValid = true;

    if (checkUsername(username)) {
        System.out.println("Username successfully captured.");
    } else {
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        isValid = false;
    }

    if (checkPasswordComplexity(password)) {
        System.out.println("Password successfully captured.");
    } else {
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        isValid = false;
    }

    if (checkCellPhoneNumber(cellPhoneNumber)) {
        System.out.println("Cell phone number successfully added.");
    } else {
        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        isValid = false;
    }

    if (isValid) {
        return "Registration successful!";
    } else {
        return "Registration failed. Please correct the above errors.";
    }
}

    // Login methods

    public boolean loginUser(String enteredUser, String enteredPassword) {
        return this.username.equals(enteredUser) && this.password.equals(enteredPassword);
    }
    public String returnLoginStatus(String enteredUser, String enteredPassword) {
        if (loginUser(enteredUser, enteredPassword)) {
            return "Login successful! Welcome " + firstName + " " +lastName + " ,it is great to see you.";
        } else {
            return "Login failed! Username or password incorrect.";
        }
}
}