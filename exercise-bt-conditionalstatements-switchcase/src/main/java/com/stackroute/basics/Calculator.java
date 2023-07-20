package com.stackroute.basics;

import java.util.Scanner;

public class Calculator {
    private static Scanner scan;

    // define,declare scanner and call getValues with scanner as parameter
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        new Calculator().getValues(scan);
    }

    //Get values and which operator from the menu
    public void getValues(Scanner scan) {
        char choice;
        String result;
       do {
//           System.out.println("Enter the NUmber 1");
           int num1 = scan.nextInt();
//           System.out.println("enter the NUmber 2");
           int num2 = scan.nextInt();
//           System.out.println("Enter your choice:" +
//                   "\n1.Addition," +
//                   "\n2.difference" +
//                   "\n3.Multiplication" +
//                   "\n4.diviion");
           int operator = scan.nextInt();
           result = calculate(num1,num2,operator);
//           System.out.println("Do you want to continue (y/N)");
           choice = scan.next().charAt(0);

       } while (choice!='n');
        System.out.println(result);
    }

    //perform operation based on the chosen switch case corresponding to the menu and return string
    public String calculate(int firstValue, int secondValue, int operator) {
         String out = "";
        switch ( operator){
            case 1 :
                out= firstValue + " + " +secondValue+" = "+(firstValue+secondValue);
                break;
            case 2:
                out= firstValue + " - " +secondValue+" = "+(firstValue-secondValue);
                break;
            case 3:
                out= firstValue + " * " +secondValue+" = "+(firstValue*secondValue);
                break;
            case 4:
                if(secondValue==0){
                    out="The divider (secondValue) cannot be zero";
                    break;
                }
                out= firstValue +" / "+secondValue+" = "+(firstValue/secondValue);
                break;

            default:
                out="Entered wrong option "+operator;
        }
        return out;
    }
   
}
