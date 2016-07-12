package com.zackwantsfriends.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.zackwantsfriends.components.TextureComponent;

public class PlayerGameObject extends AbstractGameObject implements InputProcessor {
    public PlayerGameObject() {
        super();
        setSize(32, 32);
        // Create a new Texture component using the spritesheet "zombie.png"
        // Each tile is 32x32
        // We want it to animate, and change frames after 0.3 seconds
        TextureComponent textureComponent = new TextureComponent("zombie.png", 32, 32, true, 0.3f);
        addComponent(textureComponent);
        initialize();
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        Gdx.input.setInputProcessor(new InputMultiplexer(this, stage));
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
