package com.stackroute.collections;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {
    //write logic to find binary number from 1 to given input
    public String findBinaryNumbersSequence(int input) {

        int n = input;

        if (n <= 0){
            return "Give proper input not zero or negative";
        }
        else if(n > 20){
            return "Give proper input not greater than 20";
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        StringBuilder result = new StringBuilder();

        for (int i = 1;i <= n; i++){
            String binaryNumber = queue.poll();
            result.append(binaryNumber).append(" ");
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }

        return result.toString().trim();

    }
}