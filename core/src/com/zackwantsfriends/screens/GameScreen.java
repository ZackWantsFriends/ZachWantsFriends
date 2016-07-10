package com.zackwantsfriends.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameScreen extends AbstractScreen {
    @Override
    public void buildStage() {
        Actor testActor = new Image(new Texture("badlogic.jpg"));
        testActor.setSize(100, 100);
        this.addActor(testActor);
    }
}
