package com.zackwantsfriends.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.zackwantsfriends.TheGame;

public class MainMenuScreen extends AbstractScreen {

    private Texture backgroundTexture;
    private Texture logoTexture;
    private float logoScale = 0.75f;
    private float logoOffsetY = 80;
    private int selectedLabelIndex;

    private String[] menuEntries;


    public MainMenuScreen() {
        backgroundTexture = new Texture(Gdx.files.internal("backgrounds.png"));
        logoTexture = new Texture(Gdx.files.internal("ui/logo.png"));
        menuEntries = new String[3];
        menuEntries[0] = "START GAME";
        menuEntries[1] = "ABOUT";
        menuEntries[2] = "EXIT";

    }

    @Override
    public void buildStage() {

    }

    @Override
    public boolean keyDown(int keyCode) {
        switch (keyCode) {
            case Input.Keys.UP:
                selectedLabelIndex--;
                return true;
            case Input.Keys.DOWN:
                selectedLabelIndex++;
                return true;
            default:
                return false;
        }
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