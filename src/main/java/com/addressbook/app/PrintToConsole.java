package com.addressbook.app;

import java.util.ArrayList;

public class PrintToConsole {

    public static void print(Contact contact) {
        System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail());
    }

    public static void print(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhoneNumber() + ", Email: " + contact.getEmail());
        }
    }
}