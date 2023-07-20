package com.stackroute.basics;


import java.util.Scanner;

public class SortAscNumber {

    public static void main(String[] args) {

        new SortAscNumber().getNumbers();
    }

    //get the numbers from user through console
    public void getNumbers() {
        int num1,num2,num3,num4;
        String result;
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        num4 = sc.nextInt();

        result =new SortAscNumber().numberSorter(num1,num2,num3,num4);
        System.out.println(result);
    }

    //logic to sort the numbers
    public String numberSorter(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {

        int firstplace = 0, secondplace = 0, thirdplace = 0, fourthplace = 0;
        
        //FirstPlace
        if(firstNumber <= secondNumber && firstNumber <= thirdNumber && firstNumber <= fourthNumber){
            firstplace = firstNumber;
        } else if (secondNumber <= firstNumber && secondNumber <= thirdNumber && secondNumber <= fourthNumber) {
            firstplace = secondNumber;
        } else if (thirdNumber <= firstNumber && thirdNumber <= secondNumber && thirdNumber <= fourthNumber) {
            firstplace = thirdNumber;
        } else if (fourthNumber <= firstNumber && fourthNumber <= secondNumber && fourthNumber <= thirdNumber) {
            firstplace = fourthNumber;
        }

        //FourthPlace
        if(firstNumber >= secondNumber && firstNumber >= thirdNumber && firstNumber >= fourthNumber){
            fourthplace = firstNumber;
        } else if (secondNumber >= firstNumber && secondNumber >= thirdNumber && secondNumber >= fourthNumber) {
            fourthplace = secondNumber;
        } else if (thirdNumber >= firstNumber && thirdNumber >= secondNumber && thirdNumber >= fourthNumber) {
            fourthplace = thirdNumber;
        } else if (fourthNumber >= firstNumber && fourthNumber >= secondNumber && fourthNumber >= thirdNumber) {
            fourthplace = fourthNumber;
        }

        //SecondPlace & ThirdPlace.

        int tempfirst = firstplace, tempsecond = fourthplace;

        if(firstNumber != firstplace && firstNumber != fourthplace) {
            tempfirst = firstNumber;
            if (secondNumber != firstplace && secondNumber != fourthplace) {
                tempsecond = secondNumber;
            } else if (thirdNumber != firstplace && thirdNumber != fourthplace) {
                tempsecond = thirdNumber;
            } else{
                tempsecond = fourthNumber;
            }
        }

        if(secondNumber != firstplace && secondNumber != fourthplace) {
            tempfirst = secondNumber;
            if (thirdNumber != firstplace && thirdNumber != fourthplace) {
                tempsecond = thirdNumber;
            } else if (fourthNumber != firstplace && fourthNumber != fourthplace) {
                tempsecond = fourthNumber;
            } else{
                tempsecond = firstNumber;
            }
        }

        if(thirdNumber != firstplace && thirdNumber != fourthplace) {
            tempfirst = thirdNumber;
            if (firstNumber != firstplace && firstNumber != fourthplace) {
                tempsecond = firstNumber;
            } else if (secondNumber != firstplace && secondNumber != fourthplace) {
                tempsecond = secondNumber;
            } else{
                tempsecond = fourthNumber;
            }
        }

        if(fourthNumber != firstplace && fourthNumber != fourthplace) {
            tempfirst = fourthNumber;
            if (firstNumber != firstplace && firstNumber != fourthplace) {
                tempsecond = firstNumber;
            } else if (secondNumber != firstplace && secondNumber != fourthplace) {
                tempsecond = secondNumber;
            } else{
                tempsecond = thirdNumber;
            }
        }

        if (tempfirst >= tempsecond) {
            thirdplace = tempfirst;
            secondplace = tempsecond;
        }else {
            thirdplace = tempsecond;
            secondplace = tempfirst;
        }

        return "Sorted:{"+firstplace+","+secondplace+","+thirdplace+","+fourthplace+"}";
    }
}
