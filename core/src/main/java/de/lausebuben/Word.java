package de.lausebuben;

public class Word {
    private StringBuilder word;
    private int maxLength = 5;

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

    public String getWord() {
        return word.toString();
    }

    public void clear() {
        word.setLength(0);
    }

    public String getText() {
        return word.toString();
    }

}
