package org.academiadecodigo.maindalorians.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
    public static Texture texture;
    public static TextureRegion bg;
    public static Texture GameOvertexture;

    public static void load() {
        texture = new Texture(Gdx.files.internal("background.png"));
        bg = new TextureRegion(texture, 1200,750);
        GameOvertexture = new Texture(Gdx.files.internal("gameover1.png"));
    }
}
