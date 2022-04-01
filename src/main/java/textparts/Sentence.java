package textparts;

import java.util.List;

public class Sentence {

    protected List<Word> words;
    protected PunctuationMark punctuationMark;

    public Sentence(List<Word> words, PunctuationMark punctuationMark) {
        this.words = words;
        this.punctuationMark = punctuationMark;
    }

    public List<Word> getWords() {
        return words;
    }

    public PunctuationMark getPunctuationMark() {
        return punctuationMark;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Sentence uniteWords(Sentence sentence) {
        for (int i = 0; i < sentence.words.size(); i++)
            this.words.add(sentence.getWords().get(i));
        this.punctuationMark = sentence.punctuationMark;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            sentence.append(word.getLetters()).append(" ");
        }
        return sentence.delete(sentence.length() - 1, sentence.length()).toString()
                + punctuationMark.getSymbol();
    }
}
