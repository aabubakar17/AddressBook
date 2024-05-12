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


            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContactTwo.getName()).thenReturn("rayne wooney");
            when(mockContactTwo.getPhoneNumber()).thenReturn("07956806754");
            when(mockContactTwo.getEmail()).thenReturn("rayne.wooney@gmail.com");
        }

        @Test
        @DisplayName("Test searching for a contact by name")
        void testSearchingForAContactByName() {
            //ARRANGE


            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByName("rayne wooney");

            //ASSERT
            assertEquals("rayne wooney", foundContact.getName());
            assertTrue(testAddressBook.viewAllContacts().contains(foundContact));
        }

        @Test
        @DisplayName("Test searching for a non-existent contact by name")
        void testSearchingForNonExistentContactByName() {
            //ARRANGE


            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByName("pan versie");

            //ASSERT
            assertNull(foundContact);
        }


    }
    @Nested
    @DisplayName("editContacts")
    class editContacts{
        private AddressBook testAddressBook;
        private ContactManager contactManager;
        private Contact mockContact;
        private Contact updatedContact;

        @BeforeEach
        public void setUp() {
            contactManager = new ContactManager();
            testAddressBook = new AddressBook(contactManager);
            mockContact = mock(Contact.class);
        }
        @Test
        @DisplayName("Test editing a contact's name")
        void testEditingAContactsName() {
            // ARRANGE
            updatedContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");
            when(updatedContact.getName()).thenReturn("rayne wooney");


            // ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.editContact(mockContact, updatedContact);

            // ASSERT
            assertEquals("rayne wooney", testAddressBook.viewAllContacts().get(0).getName());
        }



        @Test
        @DisplayName("Test editing a contact's phone number")
        void testEditingAContactsPhoneNumber() {
            // ARRANGE
            updatedContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");
            when(updatedContact.getPhoneNumber()).thenReturn("07777777777");


            // ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.editContact(mockContact, updatedContact);

            // ASSERT
            assertEquals("07777777777", testAddressBook.viewAllContacts().get(0).getPhoneNumber());
        }


        @Test
        @DisplayName("Test editing a contact's email address")
        void testEditingAContactsEmailAddress() {
            // ARRANGE
            updatedContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");
            when(updatedContact.getEmail()).thenReturn("rayne.wooney@gmail.com");


            // ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.editContact(mockContact, updatedContact);

            // ASSERT
            assertEquals("rayne.wooney@gmail.com", testAddressBook.viewAllContacts().get(0).getEmail());
        }
    }
}
