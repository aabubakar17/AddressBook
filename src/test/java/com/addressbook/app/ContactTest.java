package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {
    private final String name = "karry hane";
    private final String phoneNumber = "07956809739";
    private final  String email = "karry.hane@gmail.com";

    @Test
    @DisplayName("Test creating contact with name, phone number, and email address")
    void testCreateContactWithNamePhoneNumberAndEmailAddress() {

        // Act
        Contact contact = new Contact(name, phoneNumber, email);

        // Assert
        assertAll("Contact set with name, phone number and email address",
                () -> assertEquals(name, contact.getName()),
                () ->assertEquals(phoneNumber, contact.getPhoneNumber()),
                () -> assertEquals(email, contact.getEmail()));

    }

    @Test
    @DisplayName("Test creating contact with missing name")
    void testCreateContactWithMissingName() {
       String emptyName = "";
        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Contact(emptyName, phoneNumber, email));

        //Assert
        assertEquals("All contact fields are required", exception.getMessage());
    }

    @Test
    @DisplayName("Test creating contact with missing phone number")
    void testCreateContactWithMissingPhoneNumber() {
        String emptyPhoneNumber = "";
        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Contact(name, emptyPhoneNumber, email));

        //Assert
        assertEquals("All contact fields are required", exception.getMessage());
    }

    @Test
    @DisplayName("Test creating contact with missing email address")
    void testCreateContactWithMissingEmailAddress() {
        String emptyEmailAddress = "";
        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Contact(name, phoneNumber, emptyEmailAddress));

        //Assert
        assertEquals("All contact fields are required", exception.getMessage());
    }
}
