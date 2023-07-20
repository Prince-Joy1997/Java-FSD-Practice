package com.stackroute.basics;


import java.util.Scanner;

public class NumberAverage {

    public static void main(String[] args) {

        new NumberAverage().getArrayValues();

    }

    //get the values of the array from the user
    public void getArrayValues() {
        String output;
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the the limit:");
        int input = sc.nextInt();
        int array[] = new int[input];
        for (int i = 0; i < input; i++) {
            array[i] = sc.nextInt();
        }
        output = findAverage(array);
        System.out.println(output);
    }

    //write here logic to calculate the average an array
    public String findAverage(int[] inputArray) {

        int sum = 0, Avg = 0;

        if (inputArray.length == 0) {
            return "Empty array";
        }
        else {

            for (int num : inputArray) {
                if (num < 0) {
                    return "Give proper positive integer values";
                }
            }
            for (int num : inputArray) {
                sum += num;
                Avg = (sum / inputArray.length);
            }
        }
        return "The average value is: " + Avg;
    }
}
