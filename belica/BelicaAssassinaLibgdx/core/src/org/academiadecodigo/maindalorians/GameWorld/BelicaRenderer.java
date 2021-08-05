package org.academiadecodigo.maindalorians.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BelicaRenderer {

    private final BelicaWorld world;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;


    public void render() {
        Gdx.app.log("GameRenderer", "render");
    }

    public BelicaRenderer(BelicaWorld world) {
        this.world = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 750, 1200);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        //shapeRenderer = new ShapeRenderer();
        //shapeRenderer.setProjectionMatrix(cam.combined);
    }
}
