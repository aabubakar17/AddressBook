package com.addressbook.app;

import java.util.ArrayList;

public class ContactManager {
private final ArrayList<Contact> contacts;

   public ContactManager() {
      this.contacts = new ArrayList<>();
   }

   public ArrayList<Contact> getContacts() {
      return contacts;
   }

   public void addContact(Contact newContact){
      contacts.add(newContact);
   }
}
