package com.epam.nhryneuskaya.task2.textparts;

import java.util.LinkedList;
import java.util.List;

public class Sentence {

    private final PunctuationMark punctuationMark;
    private final List<Word> words;

    public Sentence(PunctuationMark punctuationMark, List<Word> words) {
        this.punctuationMark = punctuationMark;
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public PunctuationMark getPunctuationMark() {
        return punctuationMark;
    }

    public Sentence uniteSentences(Sentence sentence) {
        List<Word> words = new LinkedList<>();
        words.addAll(this.words);
        words.addAll(sentence.getWords());
        return new Sentence(sentence.getPunctuationMark(), words);
    }
}
