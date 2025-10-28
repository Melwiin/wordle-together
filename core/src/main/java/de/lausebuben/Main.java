package de.lausebuben;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Main implements ApplicationListener {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private BitmapFont font;

    private Viewport viewport;

    private Grid grid;
    private Word currentWord;
    private InputHandler inputHandler;

    @Override
    public void create() {

        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        font = new BitmapFont();

        grid = new Grid();
        currentWord = new Word();

        inputHandler = new InputHandler(currentWord, grid);
        Gdx.input.setInputProcessor(inputHandler); // send input to grid
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        shapeRenderer.begin();
        grid.drawColoredBoxes(shapeRenderer);
        shapeRenderer.set(ShapeRenderer.ShapeType.Line); // outline only
        grid.drawBox(shapeRenderer);
        shapeRenderer.end();

        batch.begin();
        grid.drawLetters(batch, font, currentWord, inputHandler.getRowCount());
        grid.drawPreviousWords(batch, font);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}
