package com.stackroute.exercises;


public class Fraction {
    //Write logic to calculate the fraction and return as a String
    public String fractionCalculator(int firstNumber, int secondNumber) {

        int result = 0;

        try {
            result = firstNumber/secondNumber;
            return ""+result;
        }catch (ArithmeticException e){
            return "java.lang.ArithmeticException: "+e.getMessage();
        }
    }
}
