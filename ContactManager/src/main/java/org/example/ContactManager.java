package org.example;

import java.util.List;

public class ContactManager implements ContactService{

    List<Contact> contactList;

    @Override
    public void addContact(Contact contact) {

        if (Validator.nameValidation(contact) && Validator.phoneValidation(contact)){
            contactList.add(contact);
            return;
        }
        System.out.println("Invalid");
    }

    @Override
    public void deleteContact(String firstname, String lastname) {


    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public Contact searchContact(String firstname, String lastname) {
        return null;
    }

    @Override
    public void displayContact(SortOption sortOption) {

    }

    @Override
    public void print() {

    }
}
