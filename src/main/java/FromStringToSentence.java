import textparts.PunctuationMark;
import textparts.Sentence;
import textparts.Word;

import java.util.LinkedList;
import java.util.List;

public class FromStringToSentence {
    public static Sentence change(String string, PunctuationMark punctuationMark) {

        List<Word> words = new LinkedList<>();
        Sentence sentence;
        String[] letters;
        String twoWordsWithComma = null;

        if (string.contains(",")) {
            for (int i = 0; i < string.split(",").length; i++) {
                twoWordsWithComma = string.split(",")[i] + ", " + string.split(",")[i + 1];
                string = string.split(",")[i] + " " + string.split(",")[i + 1];
            }
            string = twoWordsWithComma;
        }

        letters = string.split(" ");
        for (String letter : letters) {
            if (!letter.isEmpty()) words.add(new Word(string));
        }
        sentence = new Sentence(words, punctuationMark);
        return sentence;
    }
}
