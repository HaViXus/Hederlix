package Hedelix.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import Hedelix.*;

public class DesktopLauncher {
		
public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
				config.width = 1296;
		config.height = 720;
		config.vSyncEnabled = false;
		config.backgroundFPS = 0;
		config.foregroundFPS = 0;
		config.title = "Hederlix";
		
		config.audioDeviceSimultaneousSources = 50;
		
		new LwjglApplication(new MainHedelix(), config);
	}
}
