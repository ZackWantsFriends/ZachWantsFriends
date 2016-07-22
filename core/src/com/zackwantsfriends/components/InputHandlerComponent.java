package com.zackwantsfriends.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputHandlerComponent extends AbstractComponent implements InputProcessor {

    private AnimationComponent animationComponent;
    private PhysicsComponent physicsComponent;
    private Vector2 movementVector;
    private float movementSpeed;
    private float jumpHeight;

    public InputHandlerComponent() {
        movementVector = new Vector2();

        // default values
        movementSpeed = 0.8f;
        jumpHeight = 25;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }


    @Override
    public void initialize() {
        ((InputMultiplexer) Gdx.input.getInputProcessor()).addProcessor(this);
        animationComponent = getGameObject().getComponent(AnimationComponent.class);
        physicsComponent = getGameObject().getComponent(PhysicsComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        physicsComponent.addForce(movementVector.x, 0);
        if (physicsComponent.onGround) physicsComponent.addForce(0, movementVector.y);

        if (movementVector.x < 0) {
            animationComponent.setState("walking");
            animationComponent.setFlip(true);
        } else if (movementVector.x > 0) {
            animationComponent.setState("walking");
            animationComponent.setFlip(false);
        } else {
            animationComponent.setState("standing");
        }

        if(movementVector.y > 0) {
            animationComponent.setState("jumping");
        }
    }

    public Vector2 getMovementVector() {
        return movementVector;
    }

    //TODO: ability to set keymap

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                movementVector.x -= movementSpeed;
                return true;
            case Input.Keys.RIGHT:
                movementVector.x += movementSpeed;
                return true;
            case Input.Keys.UP:
                movementVector.y += jumpHeight;
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                movementVector.x += movementSpeed;
                return true;
            case Input.Keys.RIGHT:
                movementVector.x -= movementSpeed;
                return true;
            case Input.Keys.UP:
                movementVector.y -= jumpHeight;
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
