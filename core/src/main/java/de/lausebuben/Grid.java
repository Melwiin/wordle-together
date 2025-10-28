package de.lausebuben;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Grid extends InputAdapter {
    private float startX;
    private float startY;
    private float boxSize;
    private float spaceX;
    private float spaceY;
    private float rows;
    private int cols;
    private StringBuilder word;
    private Color[][] boxColors = new Color[6][5];
    private String[] previousGuesses = new String[6];//

    public Grid() {// No parameters
        this.boxSize = 50;
        this.spaceX = 10;
        this.spaceY = 30;
        this.rows = 6;
        this.cols = 5;

        float gridWidth = (cols * boxSize) + ((cols - 1) * spaceX); //spaces + box size
        this.startX = (Gdx.graphics.getWidth() - gridWidth) / 2;
        this.startY = Gdx.graphics.getHeight() - 300;

    }

    public void drawBox(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.WHITE);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                float x = startX + col * (boxSize + spaceX);
                float y = startY - row * (boxSize + spaceY);

                shapeRenderer.rect(x, y, boxSize, boxSize);
            }
        }
    }

    public void drawLetters(SpriteBatch batch, BitmapFont font, Word word, int row) {

        for (int i = 0; i < word.length(); i++) {
            float x = startX + i * (boxSize + spaceX);
            float y = startY - row * (boxSize + spaceY);

            float textX = x + (boxSize / 2) - 8;
            float textY = y + (boxSize / 2) + 5;

            String letter = String.valueOf(word.getLetter(i));
            font.draw(batch, letter, textX, textY);
        }
    }

    public void setBoxColor(int row, int col, Color color) {
        boxColors[row][col] = color;
    }


    public void drawColoredBoxes(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (boxColors[row][col] != null) {
                    float x = startX + col * (boxSize + spaceX);
                    float y = startY - row * (boxSize + spaceY);

                    shapeRenderer.setColor(boxColors[row][col]);
                    shapeRenderer.rect(x, y, boxSize, boxSize);
                }
            }
        }
    }

    public void drawPreviousWords(SpriteBatch batch, BitmapFont font) {
        for (int row = 0; row < rows; row++) {
            String singleGuess = previousGuesses[row];
            if (singleGuess == null) {
                return;
            } else {
                for (int i = 0; i < singleGuess.length(); i++) {
                    float x = startX + i * (boxSize + spaceX);
                    float y = startY - row * (boxSize + spaceY);

                    float textX = x + (boxSize / 2) - 8;
                    float textY = y + (boxSize / 2) + 5;

                    char letter = singleGuess.charAt(i);
                    font.draw(batch, String.valueOf(letter), textX, textY);

                }
            }
        }

    }

    public void addtoGuess(String guess, int row) {
        previousGuesses[row] = guess;
    }
}
