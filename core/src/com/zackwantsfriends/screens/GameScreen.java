package com.zackwantsfriends.screens;

import com.zackwantsfriends.gameobjects.PlayerGameObject;

public class GameScreen extends AbstractScreen {
    @Override
    public void buildStage() {
        PlayerGameObject player = new PlayerGameObject();
        this.addActor(player);
    }
}
