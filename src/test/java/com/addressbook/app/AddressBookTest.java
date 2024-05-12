package com.addressbook.app;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {

    @Nested
    @DisplayName("AddContact")
    class AddContact {
        private AddressBook testAddressBook;
        private ContactManager mockContactManager;
        private Contact mockContact;

        @BeforeEach
        public void setUp() {

            mockContactManager = mock(ContactManager.class);
            testAddressBook = new AddressBook(mockContactManager);
            mockContact = mock(Contact.class);
        }

        @Test
        @DisplayName("Test addContact adds given contact to address book")
        void TestAddContactAddsGivenContactToAddressBook() {
            //ARRANGE
            when(mockContactManager.getContacts()).thenReturn(new ArrayList<>(List.of(mockContact)));

            //ACT
            testAddressBook.addContact(mockContact);

           //ASSERT
            assertTrue(testAddressBook.viewAllContacts().contains(mockContact));
        }
    }
}
