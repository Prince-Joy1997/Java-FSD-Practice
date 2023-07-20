package org.example;


import java.util.List;
import java.util.stream.Collectors;

public class Arithmetic {


    int add(int a, int b){
        return a+b;

    }

    int difference(int a, int b){
        return a-b;
    }

    int division(int a, int b) throws ArithmeticException{
        try {
            return a / b;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        return a/b;
    }

    int multiply(int a, int b){
        return a*b;
    }

    List<Integer> EvenList(List<Integer> list){

        return list.stream().filter(s-> s % 2 == 0).collect(Collectors.toList());
    }
}
