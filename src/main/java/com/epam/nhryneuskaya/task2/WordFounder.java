package com.epam.nhryneuskaya.task2;

import com.epam.nhryneuskaya.task2.textparts.Sentence;
import com.epam.nhryneuskaya.task2.textparts.Word;

import java.util.LinkedList;
import java.util.List;

public final class WordFounder {

    private WordFounder() {
    }

    public static List<Word> found(List<Sentence> sentences, int wordLength) {
        List<Word> words = new LinkedList<>();
        boolean identically;
        for (Sentence sentence : sentences) {
            for (int k = 0; k < sentence.getWords().size(); k++) {
                identically = false;
                Word letters = sentence.getWords().get(k);

                if (letters.length() == wordLength && !letters.getLetters().endsWith(",")) {
                    for (Word word : words) {
                        if (letters.getLetters().equals(word.getLetters())) {
                            identically = true;
                            break;
                        }
                    }
                    if (!identically) {
                        words.add(letters);
                    }
                }
            }
        }
        return words;
    }
}
