package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private final ContactManager contactManager;


    public AddressBook(ContactManager contactManager) {
        this.contactManager = contactManager;
    }


    public void addContact(Contact contact) {
        if (contactManager.validateContact(contact)) {
            contactManager.addContact(contact);
        }

    }


    public ArrayList<Contact> viewAllContacts() {
        return contactManager.getContacts();
    }
}
