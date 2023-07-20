package com.stackroute.strings;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        LongestSubString obj = new LongestSubString();

        String output = "";
        output = String.valueOf(obj.findLongestSubString(new StringBuilder(input)));
        System.out.println(output);
    }
    //write logic to find the longest substring that appears at both ends of a given string and return result
    public StringBuilder findLongestSubString(StringBuilder input) {

        int length = input.length();
        String temp="";
        StringBuilder result=new StringBuilder("Longest substring is not present in the given StringBuilder");
        int templength;

        for (int i = 0;i < length;i++){
             temp += input.charAt(i);
             templength = temp.length();
             if (i<=length/2 && temp.equals(input.substring(length-templength,length))){

                 result = new StringBuilder((temp));
             }
        }
        return new StringBuilder(result);
    }
}
