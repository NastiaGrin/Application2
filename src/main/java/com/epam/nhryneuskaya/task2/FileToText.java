package com.epam.nhryneuskaya.task2;

import com.epam.nhryneuskaya.task2.textparts.PunctuationMark;
import com.epam.nhryneuskaya.task2.textparts.Sentence;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public final class FileToText {

    private FileToText() {
    }

    public static List<Sentence> read(String filename) throws IOException {
        List<Sentence> sentences = new LinkedList<>();

        try (InputStream is = FileToText.class.getClassLoader().getResourceAsStream(filename);
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader buffReader = new BufferedReader(reader)) {

            String line;
            Sentence partOfSentence = null;

            while ((line = buffReader.readLine()) != null) {
                int beginSentence = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (".?!".contains(line.substring(i, i + 1))) {
                        String sentencePart = line.substring(beginSentence, i);
                        PunctuationMark punctuationMark = new PunctuationMark(line.charAt(i));
                        Sentence sentence;
                        if (partOfSentence == null) {
                            sentence = StringToSentence.convert(punctuationMark, sentencePart);
                            sentences.add(sentence);
                        } else {
                            sentence = partOfSentence.uniteSentences(StringToSentence.convert(punctuationMark, sentencePart));
                            sentences.add(sentence);
                            partOfSentence = null;
                        }
                        beginSentence = i + 1;
                    } else {
                        if (i + 1 == line.length()) {
                            partOfSentence = StringToSentence.convert(new PunctuationMark(' '),
                                    line.substring(beginSentence, i + 1));
                        }
                    }
                }
            }
        }
        return sentences;
    }
}
