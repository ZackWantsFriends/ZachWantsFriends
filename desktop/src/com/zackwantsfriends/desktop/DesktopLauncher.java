package com.zackwantsfriends.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zackwantsfriends.TheGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "ZackWantsFriends";
        config.width = 1280;
        config.height = 720;

        if(arg.length > 0 && arg[0].equals("debug")) TheGame.DEBUG = true;

        new LwjglApplication(new TheGame(), config);
    }
}
