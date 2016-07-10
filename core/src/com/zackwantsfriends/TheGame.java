package com.zackwantsfriends;

import com.badlogic.gdx.Game;
import com.zackwantsfriends.screens.GameScreen;

public class TheGame extends Game {
    @Override
    public void create() {
        GameScreen gameScreen = new GameScreen();
        gameScreen.buildStage();
        setScreen(gameScreen);
    }
}
