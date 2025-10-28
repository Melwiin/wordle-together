package de.lausebuben;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Main implements ApplicationListener {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Rectangle rectangle;

    private BitmapFont font;
    private String text;

    private Viewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        rectangle = new Rectangle(200,200,10,10);
        font = new BitmapFont();

        viewport = new ScalingViewport(Scaling.fill, 800,600);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        shapeRenderer.begin();
        shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        shapeRenderer.end();

        batch.begin();
        font.draw(batch, "Hello World!", 200, 200);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
