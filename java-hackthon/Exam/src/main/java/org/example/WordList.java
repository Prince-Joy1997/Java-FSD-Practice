package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class WordList {

    List<Word> addToList(ArrayList<String> list){
        List<Word> wordList = new ArrayList();
        int count = 0;
        TreeSet<String> treeSet = new TreeSet();
        treeSet.addAll(list);
        for (String str:treeSet) {
            count = Collections.frequency(list,str);
            wordList.add(new Word(str,count));
        }
        return wordList;
    }
    void showWordList(ArrayList<Word> wordList){
        for (Word w:wordList) {
            System.out.println(w.getWord()+" occurs "+w.getCount()+" times");
        }

    }
    ArrayList<Word> reverse(ArrayList<Word> wordList){
        Collections.sort(wordList,new WordReverse());
        for (Word w:wordList) {
            System.out.println(w.getWord()+" occurs "+w.getCount()+" times");
        }
        return wordList;
    }
    ArrayList<Word> showFrequentWord(ArrayList<Word> wordList){
        Collections.sort(wordList,new CompareFrequentWords());
        for (Word w:wordList) {
            System.out.println(w.getWord()+" occurs "+w.getCount()+" times");
        }
        return wordList;
    }
}
