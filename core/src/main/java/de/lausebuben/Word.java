package de.lausebuben;

public class Word {

    public final StringBuilder word;
    private final int maxLength = 5;

    public Word() {
        word = new StringBuilder(); // needs to exit, so it isnt nullpointer
    }

    public void addLetter(char letter) {
        if (word.length() < maxLength) {
            word.append(Character.toUpperCase(letter));
        }
    }

    public void deleteLetter() {
        if (word.length() > 0) {
            word.deleteCharAt(word.length() - 1);
        }
    }

    public int length() {
        return word.length();
    }

    public char getLetter(int index) {
        if (index >= 0 && index < word.length()) {
            return word.charAt(index);
        }
        return ' ';
    }

    public void clear() {
        word.setLength(0);
    }

    @Override
    public String toString() {
        return word.toString();
    }
}
