package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Test
    @DisplayName("Test adding contact with name, phone number, and email address")
    void testAddContactWithNamePhoneNumberAndEmailAddress() {
        // Arrange
        String name = "karry hane";
        String phoneNumber = "07956809739";
        String email = "karry.hane@gmail.com";

        // Act
        Contact contact = new Contact(name, phoneNumber, email);

        // Assert
        assertAll("Contact set with name, phone number and email address",
                () -> assertEquals(name, contact.getName()),
                () ->assertEquals(phoneNumber, contact.getPhoneNumber()),
                () -> assertEquals(email, contact.getEmail()));

    }
}
