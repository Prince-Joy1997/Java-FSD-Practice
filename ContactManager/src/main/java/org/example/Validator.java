package org.example;

public class Validator {

    private Validator(){

    }

    public static boolean nameValidation(Contact contact){

        return contact.getFirstname() == null || contact.getLastname() == null ||
                contact.getFirstname().matches("a-zA-Z") || contact.getLastname().matches("a-zA-Z");
    }

    public static boolean phoneValidation(Contact contact){

        return contact.getPhone_number() == null || contact.getPhone_number().matches("^[\\d{10}]");
    }

}
