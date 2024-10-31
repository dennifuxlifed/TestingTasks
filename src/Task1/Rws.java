package Task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Rws {
    private String[] words;

    public Rws() {
        wordsToArrayFromFile();
    }

    public String getWords() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }


    private void wordsToArrayFromFile() {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader("src/Task1/words.txt"))) {
            br.lines().forEach(sb::append);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String wordsSeparated = sb.toString();
        words = wordsSeparated.split(", ");
    }

}
