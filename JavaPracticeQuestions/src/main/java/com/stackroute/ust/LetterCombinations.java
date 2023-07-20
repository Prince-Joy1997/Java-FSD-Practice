package com.stackroute.ust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public  List<String> generateCombinations(String number){

        List<String> res = new ArrayList<>();

        Map<String,List<String>> allcombinations = new HashMap<>();
        allcombinations.put("2", List.of(new String[]{"a", "b", "c"}));
        allcombinations.put("3", List.of(new String[]{"d", "e", "f"}));
        allcombinations.put("4", List.of(new String[]{"g", "h", "i"}));
        allcombinations.put("5", List.of(new String[]{"j", "k", "l"}));
        allcombinations.put("6", List.of(new String[]{"m", "n", "o"}));
        allcombinations.put("7", List.of(new String[]{"p", "q", "r","s"}));
        allcombinations.put("8", List.of(new String[]{"t","u", "v"}));
        allcombinations.put("9", List.of(new String[]{"w", "x", "y","z"}));

        if(number.length()==1){
            return allcombinations.get(String.valueOf(number.charAt(0)));}

        List<String> firstdigit = allcombinations.get(String.valueOf(number.charAt(0)));
        List<String> seconddigit = allcombinations.get(String.valueOf(number.charAt(1)));

        for(int i=0;i<firstdigit.size();i++){
            String a = "";
            for(int j=0;j<seconddigit.size();j++) {
                a = firstdigit.get(i) + seconddigit.get(j);
                res.add(a);

            }
        }


        return res;
    }
}
