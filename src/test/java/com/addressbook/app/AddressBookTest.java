package com.addressbook.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.io.ByteArrayInputStream;


public class AddressBookTest {

    @Nested
    @DisplayName("AddContact")
    class AddContact {
        private AddressBook testAddressBook;
        private Contact mockContact;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
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
        private Contact mockContact;
        private Contact mockContactTwo;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
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
            ArrayList<Contact> foundContact = testAddressBook.searchByName("rayne wooney");

            //ASSERT
            assertEquals("rayne wooney", foundContact.get(0).getName());
            assertTrue(testAddressBook.viewAllContacts().contains(foundContact.get(0)));
        }

        @Test
        @DisplayName("Test searching for a non-existent contact by name")
        void testSearchingForNonExistentContactByName() {
            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            ArrayList<Contact> foundContact = testAddressBook.searchByName("pan versie");

            //ASSERT
            assertNull(foundContact);
        }


        @Test
        @DisplayName("Test searching for a contact by Phone Number")
        void testSearchingForAContactByPhoneNumber() {

            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
           Contact foundContact = testAddressBook.searchByPhoneNumber("07956806754");

            //ASSERT
            assertEquals("07956806754", foundContact.getPhoneNumber());
            assertTrue(testAddressBook.viewAllContacts().contains(foundContact));
        }

        @Test
        @DisplayName("Test searching for a non-existent contact by Phone Number")
        void testSearchingForNonExistentContactByPhoneNumber() {

            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByPhoneNumber("7777777777");

            //ASSERT
            assertNull(foundContact);
        }

        @Test
        @DisplayName("Test searching for a contact by email address")
        void testSearchingForAContactByEmailAddress() {

            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByEmail("rayne.wooney@gmail.com");

            //ASSERT
            assertEquals("rayne.wooney@gmail.com", foundContact.getEmail());
            assertTrue(testAddressBook.viewAllContacts().contains(foundContact));
        }

        @Test
        @DisplayName("Test searching for a non-existent contact by email address")
        void testSearchingForNonExistentContactByEmailAddress() {

            //ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContactTwo);
            Contact foundContact = testAddressBook.searchByEmail("not.email@gmail.com");

            //ASSERT
            assertNull(foundContact);
        }


    }

    @Nested
    @DisplayName("editContacts")
    class editContacts {
        private AddressBook testAddressBook;

        private Contact mockContact;
        private Contact updatedContact;

        @BeforeEach
        public void setUp() {

            testAddressBook = new AddressBook();
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

        @Test
        @DisplayName("Test edit non-existent contact")
        void testEditNonExistentContact() {
            //ARRANGE
            updatedContact = mock(Contact.class);
            when(updatedContact.getEmail()).thenReturn("rayne.wooney@gmail.com");


            //ASSERT
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(mockContact, updatedContact));
        }

    }


    @Nested
    @DisplayName("RemoveContacts")
    class RemoveContacts {
        private AddressBook testAddressBook;
        private Contact mockContact;

        @BeforeEach
        public void setUp() {

            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
            when(mockContact.getName()).thenReturn("karry hane");
            when(mockContact.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact.getEmail()).thenReturn("karry.hane@gmail.com");
        }

        @Test
        @DisplayName("Test removing a contact from the address book")
        void testRemovingAContactFromAddressBook() {
            // ARRANGE

            // ACT
            testAddressBook.addContact(mockContact);
            testAddressBook.removeContact(mockContact);

            // ASSERT
            assertFalse(testAddressBook.viewAllContacts().contains(mockContact));
        }

        @Test
        @DisplayName("Test removing non-existent contact")
        void testRemovingNonExistentContact() {
            // ARRANGE

            // ACT
            testAddressBook.removeContact(mockContact);

            // ASSERT
            assertFalse(testAddressBook.viewAllContacts().contains(mockContact));
        }

    }


    @Nested
    @DisplayName("Check Contact Uniqueness")
    class CheckContactUniqueness {

        private AddressBook testAddressBook;
        private Contact mockContact1;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact1 = mock(Contact.class);
            mockContact2 = mock(Contact.class);
        }

        @Test
        @DisplayName("Test adding contact with duplicate phone number")
        void testAddingContactWithDuplicatePhoneNumber() {
            // ARRANGE
            when(mockContact1.getName()).thenReturn("karry hane");
            when(mockContact1.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact1.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContact2.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact2.getEmail()).thenReturn("rayne.wooney@gmail.com");
            when(mockContact2.getName()).thenReturn("rayne wooney");

            // ACT
            testAddressBook.addContact(mockContact1);

            // ASSERT
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact2));
        }

        @Test
        @DisplayName("Test adding contact with duplicate email address")
        void testAddingContactWithDuplicateEmailAddress() {
            // ARRANGE
            when(mockContact1.getName()).thenReturn("karry hane");
            when(mockContact1.getPhoneNumber()).thenReturn("079568865134");
            when(mockContact1.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContact2.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact2.getEmail()).thenReturn("karry.hane@gmail.com");
            when(mockContact2.getName()).thenReturn("rayne wooney");

            // ACT
            testAddressBook.addContact(mockContact1);

            // ASSERT
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact2));
        }

    }

    @Nested
    @DisplayName("View All Contacts")
    class ViewAllContacts {

        private AddressBook testAddressBook;
        private Contact mockContact1;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact1 = mock(Contact.class);
            mockContact2 = mock(Contact.class);

            when(mockContact1.getName()).thenReturn("karry hane");
            when(mockContact1.getPhoneNumber()).thenReturn("079568865134");
            when(mockContact1.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContact2.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact2.getEmail()).thenReturn("rayne.wooney@gmail.com");
            when(mockContact2.getName()).thenReturn("rayne wooney");

        }

        @Test
        @DisplayName("Test view all contacts")
        void testViewAllContacts() {

            // ACT
            testAddressBook.addContact(mockContact1);
            testAddressBook.addContact(mockContact2);

            // ASSERT
            assertAll(
                    () -> assertTrue(testAddressBook.viewAllContacts().contains(mockContact1)),
                    () -> assertTrue(testAddressBook.viewAllContacts().contains(mockContact2))
            );

        }


        @Test
        @DisplayName("Test view all contacts for empty address book")
        void testViewAllContactsForEmptyAddressBook() {

            // ASSERT
            assertTrue(testAddressBook.viewAllContacts().isEmpty());
        }


    }


    @Nested
    @DisplayName("Alphabetical Order Comments ")
    class AlphabeticalOrderContacts {
        private AddressBook testAddressBook;
        private Contact mockContact1;
        private Contact mockContact2;
        private Contact mockContact3;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact1 = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            mockContact3 = mock(Contact.class);

            when(mockContact1.getName()).thenReturn("karry hane");
            when(mockContact1.getPhoneNumber()).thenReturn("079568865134");
            when(mockContact1.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContact2.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact2.getEmail()).thenReturn("karry.wooney@gmail.com");
            when(mockContact2.getName()).thenReturn("karry wooney");

            when(mockContact3.getName()).thenReturn("karry jerry");
            when(mockContact3.getPhoneNumber()).thenReturn("079567654339");
            when(mockContact3.getEmail()).thenReturn("karry.jerry@gmail.com");

        }


        @Test
        @DisplayName("Test search by name")
        public void testSearchByName() {

            //ACT
            testAddressBook.addContact(mockContact1);
            testAddressBook.addContact(mockContact2);
            testAddressBook.addContact(mockContact3);


            ArrayList<Contact> searchResults = testAddressBook.searchByName("karry hane");

            //ASSERT
            for (int i = 0; i < searchResults.size() - 1; i++) {
                String currentName = searchResults.get(i).getName();
                String nextName = searchResults.get(i + 1).getName();
                assertTrue(currentName.compareTo(nextName) <= 0);
            }

        }
    }


    @Nested
    @DisplayName("Delete All Contacts")
    class DeleteAllContacts {
        private AddressBook testAddressBook;
        private Contact mockContact1;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact1 = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            when(mockContact1.getName()).thenReturn("karry hane");
            when(mockContact1.getPhoneNumber()).thenReturn("079568865134");
            when(mockContact1.getEmail()).thenReturn("karry.hane@gmail.com");

            when(mockContact2.getPhoneNumber()).thenReturn("07956809739");
            when(mockContact2.getEmail()).thenReturn("rayne.wooney@gmail.com");
            when(mockContact2.getName()).thenReturn("rayne wooney");
            testAddressBook.addContact(mockContact1);
            testAddressBook.addContact(mockContact2);

        }
        @Test
        @DisplayName("Test deleting all contacts")
        void testDeleteAllContacts() {


            // ACT
            ByteArrayInputStream in = new ByteArrayInputStream("yes".getBytes());
            System.setIn(in);
            testAddressBook.deleteAllContacts();

            // ASSERT
            assertTrue(testAddressBook.viewAllContacts().isEmpty());
        }

        @Test
        @DisplayName("Test canceling deletion of all contacts")
        void testCancelDeleteAllContacts() {

            // ACT
            ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes());
            System.setIn(in);
            testAddressBook.deleteAllContacts();


            // ASSERT
            assertFalse(testAddressBook.viewAllContacts().isEmpty());
        }


    }
}