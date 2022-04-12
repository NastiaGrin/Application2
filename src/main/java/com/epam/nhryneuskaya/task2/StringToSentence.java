package com.epam.nhryneuskaya.task2;

import com.epam.nhryneuskaya.task2.textparts.PunctuationMark;
import com.epam.nhryneuskaya.task2.textparts.Sentence;
import com.epam.nhryneuskaya.task2.textparts.Word;

import java.util.LinkedList;
import java.util.List;

public final class StringToSentence {

    private StringToSentence() {

    }

    public static Sentence convert(PunctuationMark punctuationMark, String string) {
        String[] str = string.split(",");
        if (str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                if (!str[i].endsWith(" ")) {
                    str[i] = str[i] + " ";
                }
            }
        }

        String[] letters = string.split(" ");
        List<Word> words = new LinkedList<>();

        if (letters.length != 0) {
            for (String letter : letters) {
                words.add(new Word(letter));
            }
        }
        return new Sentence(punctuationMark, words);
    }
}
