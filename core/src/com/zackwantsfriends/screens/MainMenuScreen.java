package com.zackwantsfriends.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen extends AbstractScreen {

    private Texture backgroundTexture;
    private Texture logoTexture;

    public MainMenuScreen() {
        backgroundTexture = new Texture(Gdx.files.internal("backgrounds.png"));
        logoTexture = new Texture(Gdx.files.internal("ui/logo.png"));

    }

    @Override
    public void buildStage() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        getBatch().begin();

        getBatch().draw(backgroundTexture, 0, 0);

        getBatch().draw(logoTexture, 200, 0, (int) logoTexture.getWidth() * 0.75f, (int) logoTexture.getHeight() * 0.75f);

        getBatch().end();
    }
}