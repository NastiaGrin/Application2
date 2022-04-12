package com.epam.nhryneuskaya.task2.textparts;

public class Word {

    private final String letters;

    public Word(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }

    public int length() {
        return letters.length();
    }
}
