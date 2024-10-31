package Task1;

import java.util.*;

public class Mask {
    private String word;
    private String[] mask;
    private final Set<String> usedLetters = new HashSet<>();
    private final Set<String> uniqueLetters = new HashSet<>();
    private int NumberOfGuessLetters = 0;

    public void setWord(String word) {
        this.word = word;
        this.mask = new String[word.length()];
        Arrays.fill(mask, "#");
        Collections.addAll(uniqueLetters, word.split(""));

    }
    public void printMask() {
        System.out.println(String.join(" ", mask));
    }

    public void updateMask(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                mask[i] = letter;
            }
        }
        NumberOfGuessLetters++;
    }
    public boolean containsLetter(String letter) {
        return uniqueLetters.contains(letter);
    }

    public void  setUserLetters(String letter) {
        usedLetters.add(letter);
    }
    public boolean AllreadyUsedLetters(String letter) {
        return usedLetters.contains(letter);
    }
    public boolean UserWon(){
        return  NumberOfGuessLetters == uniqueLetters.size() ;
    }
    public void cleanBuffer() {
        usedLetters.clear();
        uniqueLetters.clear();
        NumberOfGuessLetters = 0;
    }
}

