package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private final ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }


    public void addContact(Contact newContact) {

        if (validateContact(newContact) && checkUniqueContact(newContact)) {
        contacts.add(newContact);
        }

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

    public Contact searchByPhoneNumber(String number) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(number)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByEmail(String email) {
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                return contact;
            }
        }
        return null;
    }


    public ArrayList<Contact> viewAllContacts() {
        return contacts;
    }

    private boolean checkUniqueContact(Contact newContact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getPhoneNumber().equals(newContact.getPhoneNumber()) || existingContact.getEmail().equals(newContact.getEmail())) {
                throw new IllegalArgumentException("Contact already exist.");
            }
        }
        return true;
    }

    public boolean validateContact(Contact contact) {
        if (contact == null || contact.getName().isEmpty() || contact.getPhoneNumber().isEmpty() || contact.getEmail().isEmpty()) {
            throw new IllegalArgumentException("All contact fields are required");
        }
        return true;
    }

}
