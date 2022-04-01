import textparts.Sentence;
import textparts.Word;

import java.util.*;

public class TextApplication {
    public static void main(String[] args) {

        List<Sentence> sentences = new LinkedList<>();
        List<Word> words = new LinkedList<>();
        List<Sentence> questions = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int wordLength = 0;

        ReadTextFromFile.reader(sentences, scanner);
        QuestionFounder.found(sentences, questions);
        System.out.println("Enter length of the words.");
        try {
            wordLength = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong number of words length.");
            System.exit(4);
        }
        WordFounder.found(questions, wordLength, words);
        if (!words.isEmpty()) {
            for (Word word : words) {
                System.out.println(word.getLetters());
            }
        } else System.out.println("There isn't words with that length.");
        scanner.close();
    }
}
