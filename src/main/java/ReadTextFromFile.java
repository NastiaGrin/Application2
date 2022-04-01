import textparts.PunctuationMark;
import textparts.Sentence;

import java.io.*;
import java.util.*;

public class ReadTextFromFile {
    public static void reader(List<Sentence> sentences, Scanner scanner) {

        String filename;
        Reader reader;
        BufferedReader buffReader;
        String data;
        int beginSentence;
        Sentence partOfSentence = null;

        System.out.println("Enter way to your text file.");
        filename = scanner.nextLine();

        try {
            reader = new FileReader(filename);
            buffReader = new BufferedReader(reader);

            while ((data = buffReader.readLine()) != null) {
                beginSentence = 0;

                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == '.' || data.charAt(i) == '?' || data.charAt(i) == '!') {
                        if (partOfSentence == null) {
                            sentences.add(FromStringToSentence.change(data.substring(beginSentence, i),
                                    new PunctuationMark(data.charAt(i))));
                        } else {
                            sentences.add(partOfSentence.uniteWords(FromStringToSentence.change(data.substring(beginSentence, i),
                                    new PunctuationMark(data.charAt(i)))));
                            System.out.println(partOfSentence.getPunctuationMark().getSymbol());
                            partOfSentence = null;
                        }
                        beginSentence = i + 1;
                    } else {
                        if (i + 1 == data.length()) {
                            partOfSentence = FromStringToSentence.change(data.substring(beginSentence, i),
                                    new PunctuationMark(' '));
                        }
                    }
                }
            }
            buffReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not founded.");
            System.exit(2);
        } catch (IOException e) {
            System.out.println("Error in-output.");
            System.exit(3);
        }
    }
}
