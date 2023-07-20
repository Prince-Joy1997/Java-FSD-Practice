package com.stackroute.streams;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFormat {

    //write logic to find the format for given list and return result
    public String findStringFormat(List<Integer> input) {

        if (input.isEmpty() || input == null){
            return "Give proper input not empty list";
        }

        if (input.stream().anyMatch(i -> i < 0)){
            return "Give proper input not negative values";
        }

        return input.stream().map((num)->num%2==0?"even"+num:"odd"+num).collect(Collectors.joining(","));
    }
}
