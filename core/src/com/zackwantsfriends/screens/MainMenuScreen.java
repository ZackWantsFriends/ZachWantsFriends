package com.zackwantsfriends.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.TheGame;

public class MainMenuScreen extends AbstractScreen {

    private Texture backgroundTexture;
    private Texture logoTexture;
    private float logoScale = 0.75f;
    private float logoOffsetY = 80;

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

        int centerX = (int) ((TheGame.RESOLUTION_WIDTH / 2) - ((logoTexture.getWidth() * logoScale) / 2));
        int centerY = (int) ((TheGame.RESOLUTION_HEIGHT / 2) - ((logoTexture.getHeight() * logoScale) / 2));

        getBatch().draw(logoTexture, centerX, centerY + logoOffsetY, logoTexture.getWidth() * logoScale, logoTexture.getHeight() * logoScale);



        getBatch().end();
    }
}