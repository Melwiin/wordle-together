package de.lausebuben;

import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

public class InputHandler extends InputAdapter {
    private final Grid grid;
    private Word currentWord;
    private WordDatabase wordDatabase;
    private String targetWord;
    private int rowCount = 0;
    // Java array


    public InputHandler(Word word, Grid grid) {
        this.currentWord = word;
        this.wordDatabase = new WordDatabase();
        this.targetWord = wordDatabase.loadTargetWordFromFile();
        this.grid = grid;
    }

    public boolean keyTyped(char character) {
        if (character == '\b') {
            currentWord.deleteLetter();
        } else if (character == '\n' && currentWord.length() == 5) {
            for (int i = 0; i < currentWord.length(); i++) {

                char guessLetter = currentWord.getLetter(i);
                char targetLetter = targetWord.charAt(i);

                if (guessLetter == targetLetter) {
                    grid.setBoxColor(rowCount, i, Color.GREEN);
                } else if (targetWord.contains(String.valueOf(guessLetter))) {
                    grid.setBoxColor(rowCount, i, Color.YELLOW);
                } else {
                    grid.setBoxColor(rowCount, i, Color.GRAY);
                }


            }
            grid.addtoGuess(currentWord.getText(), rowCount);
            rowCount++;

            currentWord.clear();

        } else {
            currentWord.addLetter(character);
        }
        return true;
    }

    public int getRowCount() {
        return rowCount;
    }

}
