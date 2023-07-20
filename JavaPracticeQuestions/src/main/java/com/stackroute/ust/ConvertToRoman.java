package com.stackroute.ust;

import java.util.HashMap;
import java.util.Map;

public class ConvertToRoman {

    public String coversion(int num) {
        String s = "";
        Map<Integer, String> roman = new HashMap<>();
        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50, "L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");
        roman.put(4, "IV");
        roman.put(9, "IX");
        roman.put(40, "XL");
        roman.put(90, "XC");
        roman.put(400, "CD");
        roman.put(900, "CM");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                s = s + roman.get(values[i]);
                num = num - values[i];
            }
        }
        return s;
    }

}
