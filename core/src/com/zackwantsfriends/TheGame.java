package com.zackwantsfriends;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.zackwantsfriends.components.AnimationDefs;
import com.zackwantsfriends.screens.AbstractScreen;
import com.zackwantsfriends.screens.GameScreen;

public class TheGame extends Game {
    public static boolean DEBUG;

    private static TheGame instance;

    public static final int RESOLUTION_WIDTH = 640;
    public static final int RESOLUTION_HEIGHT = 360;

    public TheGame() {
        instance = this;
    }

    public static TheGame getInstance() {
        return instance;
    }

    @Override
    public void create() {
        // initialize animation definitions
        AnimationDefs.init();

        GameScreen gameScreen = new GameScreen();
        gameScreen.buildStage();
        setScreen(gameScreen);
    }
}
