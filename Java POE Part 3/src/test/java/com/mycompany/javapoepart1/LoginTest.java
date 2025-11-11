
package com.mycompany.javapoepart1;

import com.mycompany.javapoepart1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// used ai to simplyfying and also Asked AI to add the comments for me and now had ai do more example of tests like foe each sernario type that can make it an erro

public class LoginTest {

    @Test
    public void testCheckUsername() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        assertTrue(login.checkUsername("Sam_")); // valid
        assertFalse(login.checkUsername("Samuel")); //  missing underscore
        assertFalse(login.checkUsername("Sa_"));    //  too short
        assertFalse(login.checkUsername("Sam__"));  //  too long
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        assertTrue(login.checkPasswordComplexity("Pass@123")); // valid
        assertFalse(login.checkPasswordComplexity("pass@123")); //no capital letter
        assertFalse(login.checkPasswordComplexity("Pass1234")); //no special character
        assertFalse(login.checkPasswordComplexity("Pass@1"));   //too short
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        assertTrue(login.checkCellPhoneNumber("+27812345678")); //valid
        assertFalse(login.checkCellPhoneNumber("0812345678"));   //missing +27
        assertFalse(login.checkCellPhoneNumber("+2781234567"));  //only 8 digits
        assertFalse(login.checkCellPhoneNumber("+278123456789")); //too many digits
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        String result = login.registerUser();
        assertEquals("Username successfully captured", result); // adjust if registerUser returns more
    }

    @Test
    public void testLoginUser() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        assertTrue(login.loginUser("Sam_", "Pass@123")); //valid
        assertFalse(login.loginUser("WrongUser", "Pass@123")); //wrong username
        assertFalse(login.loginUser("Sam_", "WrongPass"));     //wrong password
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login("Samuel", "Ilunga", "Sam_", "Pass@123", "+27812345678");
        String status = login.returnLoginStatus("Sam_", "Pass@123");
        assertEquals("Login successful! Welcome Samuel Ilunga ,it is great to see you.", status);

        String failedStatus = login.returnLoginStatus("WrongUser", "WrongPass");
        assertEquals("Login failed! Username or password incorrect.", failedStatus);
    }
}