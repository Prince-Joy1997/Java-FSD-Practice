package com.stackroute.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    //write logic to check given two phrases are anagrams or not and return result
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String phraseOne = sc.nextLine();
        String phraseTwo = sc.nextLine();

        Anagram obj =new Anagram();
        String output = obj.checkAnagrams(phraseOne,phraseTwo);
        System.out.println(output);
    }
    public String checkAnagrams(String phraseOne, String phraseTwo) {

        if(phraseOne.isEmpty() || phraseTwo.isEmpty()){
            System.out.println("Give proper input not empty phrases");
        }
        else{
            phraseOne = phraseOne.replace(",","");
            phraseTwo = phraseTwo.replace(",","");

            char str1[] = phraseOne.toCharArray();
            char str2[] = phraseTwo.toCharArray();

            Arrays.sort(str1);
            Arrays.sort(str2);

            if (Arrays.equals(str1,str2)){
                return "Given phrases are anagrams";
            }

            return "Given phrases are not anagrams";
        }

        return "Give proper input not empty phrases";
    }
}
