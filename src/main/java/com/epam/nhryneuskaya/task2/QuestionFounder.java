package com.epam.nhryneuskaya.task2;

import com.epam.nhryneuskaya.task2.textparts.Sentence;

import java.util.LinkedList;
import java.util.List;

public final class QuestionFounder {

    private QuestionFounder() {
    }

    public static List<Sentence> found(List<Sentence> sentences) {
        List<Sentence> questions = new LinkedList<>();
        for (Sentence sentence : sentences) {
            if (sentence.getPunctuationMark().getSymbol() == '?') {
                questions.add(sentence);
            }
        }
        return questions;
    }
}
