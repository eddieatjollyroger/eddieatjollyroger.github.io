package org.academiadecodigo.maindalorians.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.maindalorians.BelicaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Belica Assassina";
		config.width = 1200;
		config.height = 750;
		new LwjglApplication(new BelicaGame(), config);
	}
}
