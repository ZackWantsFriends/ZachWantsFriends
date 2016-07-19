package com.zackwantsfriends;

import com.badlogic.gdx.Game;
import com.zackwantsfriends.components.AnimationDefs;
import com.zackwantsfriends.screens.GameScreen;

public class TheGame extends Game {
    public static boolean DEBUG;

    public TheGame() {

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
