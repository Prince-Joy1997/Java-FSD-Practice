package com.stackroute.basics;

import java.util.Scanner;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //call the functions in the required sequence
        new PhoneNumberValidator().getInput();
    }

    public String getInput() {
        String input;
        int output;
        input = sc.nextLine();
        output = validatePhoneNumber(input);
        displayResult(output);
        return null;
    }

    public void displayResult(int result) {
        //displays the result
        if(result == 1){
            System.out.println("Valid");
        } else if (result == 0) {
            System.out.println("Invalid");
        }
        else {
            System.out.println("emptystring");
        }
    }

    public int validatePhoneNumber(String input) {
        int count = 0,flag = 0;
        if(input == null || input.isEmpty()){
            return -1;
        }
        else {
            for (int i = 0; i<input.length();i++){
                char c = input.charAt(i);
                if(Character.isDigit(c) || c == '-'){
                    if (Character.isDigit(c)){
                        count++;
                    }
                }
                else {
                    flag = 1;
                }
            }
            if(flag == 0 && count == 10){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public void closeScanner(){
        //close the Scanner object
        sc.close();
    }
}
