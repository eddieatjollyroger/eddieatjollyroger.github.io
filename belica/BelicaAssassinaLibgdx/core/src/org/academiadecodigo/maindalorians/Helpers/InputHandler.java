package org.academiadecodigo.maindalorians.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import org.academiadecodigo.maindalorians.GameObjects.Ship;

public class InputHandler implements InputProcessor {
    private Ship ship;


    public InputHandler(Ship ship) {

        this.ship = ship;
    }

    @Override
    public boolean keyDown(int keycode) {
        Gdx.app.log("GameWorld", String.valueOf(keycode));
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
