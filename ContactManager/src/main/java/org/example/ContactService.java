package org.example;

public interface ContactService {

    void addContact(Contact contact);
    void deleteContact(String firstname, String lastname);
    void updateContact(Contact contact);
    Contact searchContact(String firstname, String lastname);
    void displayContact(SortOption sortOption);
    void print();

}
