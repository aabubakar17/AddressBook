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

   public void addContact(Contact newContact) {
      contacts.add(newContact);
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

   public boolean validateContact(Contact contact) {
      if (contact == null || contact.getName().isEmpty() || contact.getPhoneNumber().isEmpty() || contact.getEmail().isEmpty()) {
         throw new IllegalArgumentException("All contact fields are required");
      }
      return true;
   }
}
