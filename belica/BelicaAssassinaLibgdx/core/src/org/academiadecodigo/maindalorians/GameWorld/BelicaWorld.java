package org.academiadecodigo.maindalorians.GameWorld;

import com.badlogic.gdx.Gdx;
import org.academiadecodigo.maindalorians.GameObjects.Ship;

public class BelicaWorld {
    private Ship ship;

    public BelicaWorld(){
    ship = new Ship(0, 450, 152, 77);
    }

    public void update(float delta) {
        //Gdx.app.log("GameWorld", "update");
    }

    public Ship getShip() {
        return ship;
    }
}
