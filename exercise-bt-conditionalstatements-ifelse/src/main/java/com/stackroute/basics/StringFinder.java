package com.stackroute.basics;

import java.util.Scanner;

public class StringFinder {
    //Create Scanner object as instance variable
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Get three strings from the user
        StringFinder stringFinder = new StringFinder();
        stringFinder.getInput();
    }

    public String getInput() {
        String searchString = sc.nextLine();
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();
        int result = findString(searchString,firstString,secondString);
        displayResult(result);
        sc.close();
        return null;
    }

    public void displayResult(int result) {
        //displays the result
        if (result == 1){
            System.out.println("Found as expected");
        }
        if (result == 0){
            System.out.println("Not found");
        }
        if (result == -1){
            System.out.println("Empty string or null");
        }
    }

    public int findString(String searchString, String firstString, String secondString) {
        if(searchString == null || firstString == null || secondString == null){
            return -1;
        }
        else if(searchString.isEmpty() || firstString.isEmpty() || secondString.isEmpty()){
            return -1;
        }
        else {
            int position1 = searchString.indexOf(firstString);
            int position2 = searchString.indexOf(secondString);

            if(position1 < position2 && position1 != -1 && position2 != -1){
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public void closeScanner() {
        sc.close();
    }
}
