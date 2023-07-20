package com.stackroute.exercises;


import java.util.Collections;
import java.util.List;

public class StringSort {


    //write here logic to sort a string List
    public String stringSorter(List<String> stringList, String sortingOrder) {

        String result="";

        if (stringList == null || sortingOrder == null || stringList.isEmpty() || sortingOrder.isEmpty() || sortingOrder.contains(" ")) {
            return "Given stringList or sortingOrder is empty, null or blank space";
        }
        if (stringList.contains("") || stringList.contains(" ")) {
            return "The list contains an empty or blank space value";
        }
        if (stringList.size() == 1) {
            return "The list contains only one value";
        }

        if (sortingOrder.equalsIgnoreCase("desc")) {
            Collections.sort(stringList, (s1,s2) -> s2.compareTo(s1));
            for (String str : stringList) {
                result = result+str+", ";
            }
            result = result.substring(0,result.length()-2);
            return result= "["+result+"]";
        }

        if (sortingOrder.equalsIgnoreCase("asc")) {

            Collections.sort(stringList, (s1,s2) -> s1.compareTo(s2));
            for (String str : stringList) {
              result = result+str+", ";
            }
            result = result.substring(0,result.length()-2);
            return result= "["+result+"]";
        }
            return "No sorting order present for given string '" +sortingOrder+ "' , 'asc' for ascending order sort and 'desc' for descending order sort";
    }
}
