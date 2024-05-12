package com.addressbook.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Nested
    @DisplayName("AddContact")
    class AddContact {
        private AddressBook testAddressBook;
        private ContactManager contactManager;
        private Contact mockContact;

        @BeforeEach
        public void setUp() {
            contactManager = new ContactManager();
            testAddressBook = new AddressBook(contactManager);
            mockContact = mock(Contact.class);
        }

        @Test
        @DisplayName("Test addContact adds given contact to address book")
        void TestAddContactAddsGivenContactToAddressBook() {
            //ARRANGE
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");

            //ACT
            testAddressBook.addContact(mockContact);

            //ASSERT
            assertTrue(testAddressBook.viewAllContacts().contains(mockContact));
        }

        @Test
        @DisplayName("Test addContact throws error for contact with empty fields")
        void testAddContactThrowsErrorForContactWithEmptyFields() {
            //ARRANGE
            when(mockContact.getName()).thenReturn("");
            when(mockContact.getPhoneNumber()).thenReturn("");
            when(mockContact.getEmail()).thenReturn("");

            // ASSERT
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact));
        }
    }

    @Nested
    @DisplayName("SearchContact")
    class SearchContact {
        private AddressBook testAddressBook;
        private ContactManager contactManager;
        private Contact mockContact;
        private Contact mockContactTwo;

        @BeforeEach
        public void setUp() {
            contactManager = new ContactManager(); // Using real ContactManager instance
            testAddressBook = new AddressBook(contactManager);
            mockContact = mock(Contact.class);
            mockContactTwo = mock(Contact.class);
        }

        @Test
        @DisplayName("Test searching for a contact by name")
        void testSearchingForAContactByName() {
            //ARRANGE
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContactTwo.getName()).thenReturn("rayne wooney");
            when(mockContactTwo.getPhoneNumber()).thenReturn("07956806754");
            when(mockContactTwo.getEmail()).thenReturn("rayne.wooney@gmail.com");

            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByName("rayne wooney");

            //ASSERT
            assertEquals("rayne wooney", foundContact.getName());
            assertTrue(testAddressBook.viewAllContacts().contains(foundContact));
        }
    }
}
