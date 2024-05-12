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

    public Contact searchByName(String name) {
        ArrayList<Contact> allContacts = contactManager.getContacts();
        for (Contact contact : allContacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }
    public ArrayList<Contact> viewAllContacts() {
        return contactManager.getContacts();
    }
}
