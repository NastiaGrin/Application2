import textparts.Sentence;
import textparts.Word;

import java.util.List;

public class WordFounder {
    public static void found(List<Sentence> sentences, int wordLength, List<Word> words) {

        boolean identically;

        for (Sentence sentence : sentences) {
            for (int k = 0; k < sentence.getWords().size(); k++) {
                identically = false;

                if (sentence.getWords().get(k).length() == wordLength) {
                    for (Word word : words) {
                        if (sentence.getWords().get(k).getLetters().equals(word.getLetters())) {
                            identically = true;
                        }
                    }
                    if (!identically) {
                        words.add(sentence.getWords().get(k));
                    }
                }
            }
        }
    }
}
