package com.zackwantsfriends.screens;

import com.badlogic.gdx.graphics.Camera;
import com.zackwantsfriends.GameObject;
import com.zackwantsfriends.components.TestComponent;
import com.zackwantsfriends.components.TextureComponent;

public class GameScreen extends AbstractScreen {
    @Override
    public void buildStage() {
        GameObject player = new GameObject();
        player.addComponent(new TestComponent());
        player.addComponent(new TextureComponent());
        this.addActor(player);
    }
}
