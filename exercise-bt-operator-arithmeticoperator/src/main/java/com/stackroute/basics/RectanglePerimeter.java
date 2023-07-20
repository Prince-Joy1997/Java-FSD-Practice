package com.stackroute.basics;


import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        new RectanglePerimeter().getValues();
    }

    //get user input from console
    public void getValues() {

        Scanner sc = new Scanner(System.in);
        Double length, breadth,result;

        length = sc.nextDouble();
        breadth = sc.nextDouble();

        RectanglePerimeter obj = new RectanglePerimeter();
        result = obj.perimeterCalculator(length,breadth);
        System.out.println(result);
    }

    //write logic to find perimeter of rectangle here
    public double perimeterCalculator(double length, double breadth) {

        double result;
        result = 2*(length + breadth);
        return result;
    }
}
