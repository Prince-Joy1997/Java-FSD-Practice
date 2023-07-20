package com.stackroute.lamdbaexpression;

import java.util.*;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {
    //write logic to find the values that starts with letter I in the given list
    public List<String> findPattern(List<String> list) {

        Predicate<String> containsLetterI = p -> p.startsWith("I");

        Set<String> outputList = new LinkedHashSet<>();
        for (String str: list){
            if (containsLetterI.test(str)){

                outputList.add(str);

            }
        }
        ArrayList<String> result
                = new ArrayList<>(outputList);
        return result;
    }
}
