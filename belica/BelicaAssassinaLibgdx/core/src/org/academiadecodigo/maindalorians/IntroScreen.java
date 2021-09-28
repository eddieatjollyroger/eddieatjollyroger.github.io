package org.academiadecodigo.maindalorians;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.maindalorians.GameWorld.BelicaRenderer;
import org.academiadecodigo.maindalorians.GameWorld.BelicaWorld;

public class IntroScreen implements Screen {
    private BelicaGame belicaGame;

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Texture introTexture;
    private Sprite introSprite;

    public IntroScreen(BelicaGame belicaGame){

        this.belicaGame = belicaGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();


        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1200, 750);

        batch.setProjectionMatrix(cam.combined);

        introTexture = new Texture("splash2.png");
        introSprite = new Sprite(introTexture, 0, 0, 1200, 750);
        introSprite.setPosition(0, 0);
    }

    @Override
    public void render(float delta) {
batch.begin();
introSprite.draw(batch);
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
