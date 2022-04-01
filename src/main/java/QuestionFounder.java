import textparts.Sentence;

import java.util.List;

public class QuestionFounder {
    public static void found(List<Sentence> sentences, List<Sentence> questions) {

        for (Sentence sentence : sentences) {
            if (sentence.getPunctuationMark().getSymbol() == '?') {
                questions.add(sentence);
                System.out.println(sentence);
            }
        }
    }
}
