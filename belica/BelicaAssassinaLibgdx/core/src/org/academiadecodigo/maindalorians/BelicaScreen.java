package org.academiadecodigo.maindalorians;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.maindalorians.GameWorld.BelicaRenderer;
import org.academiadecodigo.maindalorians.GameWorld.BelicaWorld;
import org.academiadecodigo.maindalorians.Helpers.AssetLoader;
import org.academiadecodigo.maindalorians.Helpers.InputHandler;

import java.util.Arrays;


public class BelicaScreen implements Screen {
    private BelicaGame belicaGame;
    private BelicaWorld world;
    private BelicaRenderer renderer;
    private Texture background;
    private Texture texture;
    private Texture textureMissil;
    private Texture mamonaTexture;
    private Sprite[] mamonaSprite = new Sprite[250];
    private Sprite[] missilSprite = new Sprite[250];
    private Sprite ship;
    private SpriteBatch batch;
    private Sprite backgroundSprite;
    private String[] direction = new String[250];
    private int[] counter = new int[250];
    private OrthographicCamera cam;

    public BelicaScreen(BelicaGame belicaGame) {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 1200;
        float gameHeight = 750;

        batch = new SpriteBatch();

        this.belicaGame = belicaGame;

        world = new BelicaWorld();
        renderer = new BelicaRenderer(world);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, gameWidth, gameHeight);

        batch.setProjectionMatrix(cam.combined);

        Gdx.input.setInputProcessor(new InputHandler(world.getShip()));

        Arrays.fill(counter, 10);

        background = new Texture("background.png");
        backgroundSprite = new Sprite(background, 0, 0, 1200, 750);
        backgroundSprite.setPosition(0, 0);

        texture = new Texture("blica2.png");
        ship = new Sprite(texture, 0, 0, 152, 77);
        ship.setPosition(0, 500);
        ship.setSize(152, 77);

        createMamona();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //Gdx.app.log("GameScreen FPS", (1/delta) + "");
        batch.begin();
        backgroundSprite.draw(batch);
        ship.draw(batch);
        moveShip();
        shootShot();
        moveMamonas();
        moveShot();
        batch.end();
        world.update(delta);

    }

    public void collisionDetect(int i) {
        for (int j = 0; j < mamonaSprite.length; j++) {
            if (mamonaSprite[j] != null && missilSprite[i]!=null){
                if (mamonaSprite[j].getY()+mamonaSprite[j].getHeight() -10 > missilSprite[i].getY() && mamonaSprite[j].getY() +10 < missilSprite[i].getY()+missilSprite[i].getHeight()
                        && mamonaSprite[j].getX() +10 < missilSprite[i].getX()+missilSprite[i].getWidth() && mamonaSprite[j].getX()+mamonaSprite[j].getWidth() -10 > missilSprite[i].getX()) {
                    System.out.println("boas");
                    missilSprite[i] = null;
                mamonaSprite[j] = null;
                createMamona();
                break;
                }
                }
            if (mamonaSprite[j] != null) {

                if (mamonaSprite[j].getY()+mamonaSprite[j].getHeight() - 10 > ship.getY() && mamonaSprite[j].getY() + 10 < ship.getY()+ship.getHeight()
                        && mamonaSprite[j].getX() + 10 < ship.getX()+ship.getWidth() && mamonaSprite[j].getX()+mamonaSprite[j].getWidth() - 10 > ship.getX()) {
                    System.out.println("u loss");
                    belicaGame.setScreen(new GameOverScreen(belicaGame));
                }
            }
            }
        }

    public void createMamona() {
        for (int i = 0; i < mamonaSprite.length; i++) {
            if (mamonaSprite[i] == null){
                mamonaTexture = new Texture("boobies1.png");
                mamonaSprite[i] = new Sprite(mamonaTexture, 0, 0, 148, 109);
                mamonaSprite[i].setPosition(1052, (float) (Math.random() * 630));
                if (Math.random() * 100 > 70) {
                    createMamona();
                }
                break;
            }
        }
    }


    public void moveMamonas() {

        for (int i = 0; i < mamonaSprite.length; i++) {
            if (mamonaSprite[i] != null) {

                if (mamonaSprite[i].getX() < 0) {
                    belicaGame.setScreen(new GameOverScreen(belicaGame));
                    counter[i] = 10;
                } else if (mamonaSprite[i].getY() < 0) {
                    mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() + 1);
                    counter[i] = 10;
                } else if (mamonaSprite[i].getY() + mamonaSprite[i].getHeight() > 750) {
                    mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() - 1);
                    counter[i] = 10;
                }
                if (counter[i] < 10) {
                    if (direction[i] == "up") {
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() + 5);
                        counter[i]++;
                    } else if (direction[i] == "down") {
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() - 5);
                        counter[i]++;
                    } else if (direction[i] == "left") {
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX() - 5, mamonaSprite[i].getY());
                        counter[i]++;
                    }
                }
                if (counter[i] == 10) {
                    int random = (int) (Math.random() * (100));


                    if (random > 70) {                                               //  is up
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() + 5);
                        direction[i] = "up";
                        counter[i] = 0;

                    } else if (40 < random && random < 71) {
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX(), mamonaSprite[i].getY() - 5);
                        direction[i] = "down";
                        counter[i] = 0;
                        // is down
                    } else if (random < 39) {                                               // is right
                        mamonaSprite[i].setPosition(mamonaSprite[i].getX() - 5, mamonaSprite[i].getY());
                        direction[i] = "left";
                        counter[i] = 0;

                    }
                }
                mamonaSprite[i].draw(batch);
                collisionDetect(i);
            }
        }
    }


    public void moveShot() {
        for (int i = 0; i < missilSprite.length; i++) {
            if (missilSprite[i] != null && (missilSprite[i].getX() + missilSprite[i].getWidth()) < 1200) {
                missilSprite[i].setPosition(missilSprite[i].getX() + 10, missilSprite[i].getY());

                missilSprite[i].draw(batch);
                collisionDetect(i);
            }
            if (missilSprite[i] != null && missilSprite[i].getX() + missilSprite[i].getWidth() > 1200) {
                missilSprite[i] = null;
            }
        }
    }

    public void shootShot() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            for (int i = 0; i < missilSprite.length; i++) {
                if (missilSprite[i] == null) {
                    textureMissil = new Texture("fireshot.png");
                    missilSprite[i] = new Sprite(textureMissil, 0, 0, 57, 10);
                    missilSprite[i].setPosition(ship.getX() + ship.getWidth(), ship.getY() + ship.getHeight() / 2);
                    missilSprite[i].draw(batch);
                    break;
                }
            }
        }
    }

    public void moveShip() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (ship.getY() + ship.getHeight() < 750)
                ship.setPosition(ship.getX(), ship.getY() + 5);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (ship.getY() > 0)
                ship.setPosition(ship.getX(), ship.getY() - 5);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (ship.getX() > 0)
                ship.setPosition(ship.getX() - 5, ship.getY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (ship.getX() + ship.getWidth() < 1200)
                ship.setPosition(ship.getX() + 5, ship.getY());
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
        texture.dispose();
        background.dispose();
    }
}
