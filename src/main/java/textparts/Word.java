package textparts;

public class Word {

    protected String letters;

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
