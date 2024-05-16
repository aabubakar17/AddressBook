package com.addressbook.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
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

    public ArrayList<Contact> searchByName(String name) {
        ArrayList<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().split(" ")[0].equals(name.split(" ")[0])) {
                searchResults.add(contact);
            }
        }
        sortContacts(searchResults);
        return searchResults.isEmpty() ? null : searchResults;
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

    private void sortContacts(ArrayList<Contact> contacts) {
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
    }


    public ArrayList<Contact> viewAllContacts() {
        return contacts;
    }

    public void deleteAllContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete all contacts? (yes/no)");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("yes")) {
            contacts.clear();
            System.out.println("All contacts deleted.");
        }
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
