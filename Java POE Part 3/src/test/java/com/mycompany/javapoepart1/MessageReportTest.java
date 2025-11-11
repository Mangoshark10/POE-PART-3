package com.mycompany.javapoepart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageReportTest {

    @BeforeEach
    public void setup() {
        MessageReport.sentMessages.clear();
        MessageReport.storedMessages.clear();
        MessageReport.disregardedMessages.clear();
        MessageReport.messageHashes.clear();
        MessageReport.messageIDs.clear();
        MessageReport.populateTestData();
    }

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        assertEquals(2, MessageReport.sentMessages.size()); // Messages 1 and 4
        assertEquals("+27834557896", MessageReport.sentMessages.get(0).getRecipient());
        assertEquals("It is dinner time !", MessageReport.sentMessages.get(1).getMessageText());
    }

    @Test
    public void testStoredMessagesArrayCorrectlyPopulated() {
        assertEquals(2, MessageReport.storedMessages.size()); // Messages 2 and 5
        assertEquals("Ok, I am leaving without you.", MessageReport.storedMessages.get(1).getMessageText());
    }

    @Test
    public void testDisregardedMessagesArrayCorrectlyPopulated() {
        assertEquals(1, MessageReport.disregardedMessages.size()); // Message 3
        assertEquals("Yohooooo, I am at your gate.", MessageReport.disregardedMessages.get(0).getMessageText());
    }

    @Test
    public void testLongestStoredMessage() {
        Message longest = MessageReport.storedMessages.get(0);
        for (Message msg : MessageReport.storedMessages) {
            if (msg.getMessageText().length() > longest.getMessageText().length()) {
                longest = msg;
            }
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest.getMessageText());
    }

    @Test
    public void testSearchByRecipient() {
        String target = "+27838884567";
        int count = 0;
        for (Message msg : MessageReport.storedMessages) {
            if (msg.getRecipient().equals(target)) {
                count++;
            }
        }
        assertEquals(2, count); // Messages 2 and 5
    }

    @Test
    public void testDeleteByHash() {
        String hashToDelete = MessageReport.storedMessages.get(0).generateHash();
        MessageReport.deleteByHash(hashToDelete);
        assertEquals(1, MessageReport.storedMessages.size()); // One message should remain
    }

    @Test
    public void testDisplayReportContent() {
        Message msg = MessageReport.sentMessages.get(0);
        assertNotNull(msg.getMessageHash());
        assertNotNull(msg.getMessageText());
        assertNotNull(msg.getRecipient());
    }
}
