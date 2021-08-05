package org.academiadecodigo.maindalorians;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.maindalorians.Helpers.AssetLoader;

public class GameOverScreen implements Screen {
    private BelicaGame belicaGame;

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite gameOverSprite;

    public GameOverScreen(BelicaGame belicaGame){

        this.belicaGame = belicaGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();


        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1200, 750);

        batch.setProjectionMatrix(cam.combined);


        gameOverSprite = new Sprite(AssetLoader.GameOvertexture, 0, 0, 1200, 750);
        gameOverSprite.setPosition(0, 0);
    }

    @Override
    public void render(float delta) {
batch.begin();
        gameOverSprite.draw(batch);
checkGameStart();
batch.end();
    }

    private void checkGameStart() {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            belicaGame.setScreen(new BelicaScreen(belicaGame));

        }
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
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
    }
}
