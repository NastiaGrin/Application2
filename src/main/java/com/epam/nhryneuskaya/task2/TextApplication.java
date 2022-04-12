package com.epam.nhryneuskaya.task2;

import com.epam.nhryneuskaya.task2.textparts.Sentence;
import com.epam.nhryneuskaya.task2.textparts.Word;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TextApplication {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.println("Enter way to your text file.");
        filename = scanner.nextLine();

        List<Sentence> sentences = FileToText.read(filename);
        List<Sentence> questions = QuestionFounder.found(sentences);
        if (!questions.isEmpty()) {
            System.out.println("Enter length of the words.");
            int wordLength;
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Wrong number of words length");
            } else {
                wordLength = scanner.nextInt();
                if (wordLength < 1) {
                    throw new IllegalArgumentException("Wrong number of words length " + wordLength);
                }
            }
            scanner.close();
            List<Word> words = WordFounder.found(questions, wordLength);
            if (!words.isEmpty()) {
                for (Word word : words) {
                    System.out.println(word.getLetters());
                }
            } else {
                System.out.println("There aren't words with that length");
            }
        } else {
            System.out.println("There aren't questions");
        }

    }
}
