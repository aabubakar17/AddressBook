package com.addressbook.app;

public class Contact {
    private  String name;
    private  String phoneNumber;
    private  String email;

    public Contact(String name, String phoneNumber, String email) {
        if (isEmpty(name) || isEmpty(phoneNumber) || isEmpty(email)) {
            throw new IllegalArgumentException("All contact fields are required");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
