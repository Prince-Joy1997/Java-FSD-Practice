package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "data/daffodils.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split("[,\\s]+");
                words.addAll(Arrays.asList(wordsInLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordList wordList = new WordList();

        ArrayList<Word> wordCounts = (ArrayList<Word>) wordList.addToList(words);

        long startTime1 = System.currentTimeMillis();
        wordList.showWordList(wordCounts);
        long endTime1 = System.currentTimeMillis();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Execution Time: " + (endTime1 - startTime1) + "ms");

        System.out.println("----------------------------------------------------------------");

        System.out.println("\nReverse\n");
        long startTime2 = System.currentTimeMillis();
        wordList.reverse(wordCounts);
        long endTime2 = System.currentTimeMillis();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Execution Time: " + (endTime2 - startTime2) + "ms");

        System.out.println("----------------------------------------------------------------");

        System.out.println("\nFrequentWords\n");
        long startTime3 = System.currentTimeMillis();
        wordList.showFrequentWord(wordCounts);
        long endTime3 = System.currentTimeMillis();
        System.out.println("----------------------------------------------------------------");

        System.out.println("Execution Time: " + (endTime3 - startTime3) + "ms");

        System.out.println("----------------------------------------------------------------");
    }
}