package com.addressbook.app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\nAddress Book Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Search by Name");
        System.out.println("3. Remove Contact");
        System.out.println("4. Edit Contact");
        System.out.println("5. View All Contacts");
        System.out.println("6. Delete All Contacts");
        System.out.println("7. Exit");
    }

    public static void addContact() {
        try {
            System.out.print("Enter contact name: ");
            String name = scanner.nextLine();
            System.out.print("Enter contact phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter contact email: ");
            String email = scanner.nextLine();

            Contact newContact = new Contact(name, phoneNumber, email);
            addressBook.addContact(newContact);
            System.out.println("Contact added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        ArrayList<Contact> searchResults = addressBook.searchByName(name);
        if (!searchResults.isEmpty()) {
            PrintToConsole.print(searchResults);
        }else{
            System.out.println("No contacts found with that name.");
        }


    }

    public static void removeContact() {
        System.out.print("Enter firstName and lastName of contact to remove: ");
        String name = scanner.nextLine();
        ArrayList<Contact> contactToRemove = addressBook.searchByName(name);
        if (!contactToRemove.isEmpty()) {
            addressBook.removeContact(contactToRemove.get(0));
            System.out.println("Contact removed successfully.");
        }else{
            System.out.println("Contact not found.");
        }

    }

    public static void editContact() {
        System.out.print("Enter name of contact to edit: ");
        String name = scanner.nextLine();
        ArrayList<Contact> oldContact = addressBook.searchByName(name);
        if (!oldContact.isEmpty()) {
                System.out.println("Enter updated details for the contact:");
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                System.out.print("New phone number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.print("New email: ");
                String newEmail = scanner.nextLine();
                Contact updatedContact = new Contact(newName, newPhoneNumber, newEmail);
                try {
                    addressBook.editContact(oldContact.get(0), updatedContact);
                    System.out.println("Contact updated successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    public static void viewAllContacts() {
        ArrayList<Contact> allContacts = addressBook.viewAllContacts();
        if (!allContacts.isEmpty()) {
            PrintToConsole.print(allContacts);
        } else {
            System.out.println("No contacts found.");
        }
    }

    public static void deleteAllContacts() {
        addressBook.deleteAllContacts();
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    searchByName();
                    break;
                case "3":
                    removeContact();
                    break;
                case "4":
                    editContact();
                    break;
                case "5":
                    viewAllContacts();
                    break;
                case "6":
                    deleteAllContacts();
                    break;
                case "7":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
