package com.stackroute.collections;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumbersCounter {
    //write logic to find maximum unique numbers count from given array in the sub array of certain length
    public String findUniqueNumbersCount(int[] inputArray, int subArrayLength) {

        if (inputArray == null){
            return "Give proper input not null array";
        }
        if (inputArray.length == 0){
            return "Give proper input not empty array";
        }
        if (subArrayLength <= 0){
            return "Give proper input, sub array length can not be negative or zero";
        }
        if (subArrayLength > inputArray.length){
            return "Give proper input, sub array length exceeds array length";
        }

        Set<Integer> unique = new HashSet<>();
        int start = 0, end = 0, maxCount = 0;

        while (end < inputArray.length){
            unique.add(inputArray[end]);
            if (end - start + 1 == subArrayLength){
                maxCount = Math.max(maxCount, unique.size());
                unique.remove(inputArray[start]);
                start++;
            }
            end++;
        }

        return "Count of Unique Numbers is "+maxCount;

    }
}
