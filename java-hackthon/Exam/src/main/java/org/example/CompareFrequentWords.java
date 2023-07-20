package org.example;

import java.util.Comparator;

public class CompareFrequentWords implements Comparator<Word> {
    int output;
    @Override
    public int compare(Word o1, Word o2) {

        if (o2.getCount() > o1.getCount()){
            output = 1;
        } else if (o1.getCount() > o2.getCount()) {
            output = -1;
        } else if (o1.getCount() == o2.getCount()) {
            output = o1.getWord().compareTo(o2.getWord());
        }
        return output;
    }
}
