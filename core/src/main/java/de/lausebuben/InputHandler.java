package de.lausebuben;

import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.graphics.Color;

public class InputHandler extends InputAdapter {
    private final Grid grid;
    private final Word currentWord;
    private final WordDatabase wordDatabase;
    private final String targetWord;
    private int rowCount = 0;

    public InputHandler(Word word, Grid grid) {
        this.currentWord = word;
        this.wordDatabase = new WordDatabase();
        this.targetWord = wordDatabase.selectRandomWord();
        this.grid = grid;
    }

    public boolean keyTyped(char character) {
        if (character == '\b') {
            currentWord.deleteLetter();
        } else if (character == '\n' && currentWord.length() == 5) {
            checkWord();
        } else {
            currentWord.addLetter(character);
        }

        return true;
    }

    private void checkWord() {

        StringBuilder targetWordToCheck = new StringBuilder(targetWord);

        for (int i = 0; i < currentWord.length(); i++) {
            char guessLetter = currentWord.getLetter(i);
            char targetLetter = targetWordToCheck.charAt(i);

            if (guessLetter == targetLetter) {
                grid.setBoxColor(rowCount, i, Color.GREEN);
                targetWordToCheck.replace(i, i, "_");
            } else if (targetWordToCheck.toString().contains(String.valueOf(guessLetter))) {
                grid.setBoxColor(rowCount, i, Color.YELLOW);
                targetWordToCheck.replace(i, i, "_");
            } else {
                grid.setBoxColor(rowCount, i, Color.GRAY);
            }

        }

        grid.addToGuess(currentWord.toString(), rowCount);
        rowCount++;

        currentWord.clear();
    }

    public int getRowCount() {
        return rowCount;
    }
}
