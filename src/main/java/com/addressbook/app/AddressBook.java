package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private final ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }


    public void addContact(Contact newContact) {

        if (validateContact(newContact)) {
        contacts.add(newContact);}
    }

    public void editContact(Contact oldContact, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            if (c.equals(oldContact)) {
                contacts.set(i, updatedContact);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found: " + updatedContact);
    }

    public void removeContact(Contact removeContact){
        contacts.remove(removeContact);
    }

    public Contact searchByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Contact> viewAllContacts() {
        return contacts;
    }

    public boolean validateContact(Contact contact) {
        if (contact == null || contact.getName().isEmpty() || contact.getPhoneNumber().isEmpty() || contact.getEmail().isEmpty()) {
            throw new IllegalArgumentException("All contact fields are required");
        }
        return true;
    }

}
