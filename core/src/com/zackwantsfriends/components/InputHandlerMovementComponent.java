package com.zackwantsfriends.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

public class InputHandlerMovementComponent extends AbstractComponent implements InputProcessor {
    private float movementVector;

    @Override
    public void initialize() {
        ((InputMultiplexer) Gdx.input.getInputProcessor()).addProcessor(this);
    }

    @Override
    public void update(float deltaTime) {
        getGameObject().moveBy(movementVector, 0);
    }

    public float getMovementVector() {
        return movementVector;
    }

    //TODO: ability to set keymap

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                movementVector--;
                return true;
            case Input.Keys.RIGHT:
                movementVector++;
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                movementVector++;
                return true;
            case Input.Keys.RIGHT:
                movementVector--;
                return true;
            default:
                return false;
        }
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
