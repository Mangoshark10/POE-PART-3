/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.javapoepart1;

import com.mycompany.javapoepart1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageTest {

    public MessageTest() {
    }

    @Test
    public void testCheckMessageID() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight", 1);
        assertTrue(msg.checkMessageID(), "Message ID should be 10 digits");
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message("+27718693002", "Test message", 1);
        assertEquals(1, msg.checkRecipientCell(), "Valid recipient should return 1");
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message("08575975889", "Test message", 1);
        assertEquals(0, msg.checkRecipientCell(), "Invalid recipient should return 0");
    }

    @Test
    public void testCheckMessageLengthSuccess() {
        Message msg = new Message("+27718693002", "Short message", 1);
        assertEquals(1, msg.checkMessageLength(), "Valid message length should return 1");
    }

    @Test
    public void testCheckMessageLengthFailure() {
        String longMessage = "A".repeat(300);
        Message msg = new Message("+27718693002", longMessage, 1);
        assertEquals(0, msg.checkMessageLength(), "Too long message should return 0");
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("+27718693002", "Hi Keegan, did you receive the payment?", 4);
        String hash = msg.createMessageHash("0012345678", 4, "Hi Keegan, did you receive the payment?");
        assertEquals("00:04HIPAYMENT", hash, "Hash should match expected format");
    }

    @Test
    public void testGetDetails() {
        Message msg = new Message("+27718693002", "Hello world", 1);
        String details = msg.getDetails();
        assertTrue(details.contains("Message ID:"), "Details should include Message ID");
        assertTrue(details.contains("Message Hash:"), "Details should include Message Hash");
        assertTrue(details.contains("Recipient:"), "Details should include Recipient");
        assertTrue(details.contains("Message:"), "Details should include Message");
    }
    
    @Test
    public void testReturnTotalMessages() {
        int before = Message.returnTotalMessages();
        Message msg = new Message("+27718693002", "Test", 1);
        msg.SentMessage();
        int after = Message.returnTotalMessages();
        assertTrue(after >= before, "Total messages should increase or stay the same");
    }
    
    @Test
    public void testStoreMessage() {
        Message msg = new Message("+27718693002", "Store this message", 1);
        assertDoesNotThrow(() -> msg.storeMessage(), "storeMessage should not throw exception");
    }
}
