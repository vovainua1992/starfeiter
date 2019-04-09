package com.space_feiter.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.space_feiter.Main;
import com.space_feiter.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 60; // Setting to 0 disables foreground fps throttling
		//config.backgroundFPS = 0;

		config.width = 1200;
		config.height = 800;
		config.fullscreen = true;
	}
}
