package com.addressbook.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PrintToConsoleTest {
    private Contact mockContact;
    private Contact mockContact2;
    private ArrayList<Contact> mockContacts;

    @BeforeEach
    void setUp() {
        mockContact = mock(Contact.class);
        mockContact2 = mock(Contact.class); // Corrected initialization
        mockContacts = new ArrayList<>();
        mockContacts.add(mockContact);
        mockContacts.add(mockContact2);
    }

    @Test
    void testPrintSingleContact() {
        // Mocking the behavior of the contact's getters
        when(mockContact.getName()).thenReturn("John Doe");
        when(mockContact.getPhoneNumber()).thenReturn("123-456-7890");
        when(mockContact.getEmail()).thenReturn("johndoe@example.com");

        // Capturing the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PrintToConsole.print(mockContact); // Assuming this is a static method

        // Asserting the expected output
        String expectedOutput = "Name: John Doe, Phone: 123-456-7890, Email: johndoe@example.com\n";
        assertEquals(expectedOutput, outContent.toString());

        // Resetting the standard output
        System.setOut(System.out);
    }

    @Test
    void testPrintMultipleContacts() {
        // Mocking the behavior of the contacts' getters
        when(mockContact.getName()).thenReturn("karry hane");
        when(mockContact.getPhoneNumber()).thenReturn("07956809739");
        when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");

        when(mockContact2.getName()).thenReturn("rayne wooney");
        when(mockContact2.getPhoneNumber()).thenReturn("07956806754");
        when(mockContact2.getEmail()).thenReturn("rayne.wooney@gmail.com");

        // Capturing the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PrintToConsole.print(mockContacts); // Assuming this is a static method

        // Asserting the expected output
        String expectedOutput = "Name: karry hane, Phone: 07956809739, Email: karry.hane@gmail.com\n"
                + "Name: rayne wooney, Phone: 07956806754, Email: rayne.wooney@gmail.com\n";
        assertEquals(expectedOutput, outContent.toString());

        // Resetting the standard output
        System.setOut(System.out);
    }
}
