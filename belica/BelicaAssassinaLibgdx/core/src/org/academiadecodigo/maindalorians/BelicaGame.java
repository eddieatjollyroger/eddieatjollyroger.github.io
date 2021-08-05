package org.academiadecodigo.maindalorians;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.maindalorians.Helpers.AssetLoader;

public class BelicaGame extends Game {
    @Override
    public void create() {
        AssetLoader.load();
            setScreen(new IntroScreen(this));
    }
}
