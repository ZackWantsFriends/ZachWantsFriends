package com.zackwantsfriends.components;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Map;

public class AnimationComponent extends AbstractComponent {
    private Map<String, Animation> animationMap;
    private String currentState;
    private Animation currentAnimation;
    private float stateTime;
    private boolean flip;

    /**
     * @param animationMap map of animations
     * @param state        initial animation
     * @param flip         initial flipped state
     */
    public AnimationComponent(Map<String, Animation> animationMap, String state, boolean flip) {
        this.animationMap = animationMap;
        this.currentState = state;
        this.currentAnimation = animationMap.get(state);
        this.flip = flip;
        this.stateTime = 0;
    }

    @Override
    public void update(float deltaTime) {
        stateTime += deltaTime;
    }

    @Override
    public void render(Batch batch) {
        batch.draw(currentAnimation.getKeyFrame(stateTime), getGameObject().getX(), getGameObject().getY(),
                getGameObject().getOriginX(), getGameObject().getOriginY(),
                currentAnimation.getKeyFrame(stateTime).getRegionWidth(), currentAnimation.getKeyFrame(stateTime).getRegionHeight(),
                getGameObject().getScaleX() * (flip ? -1 : 1), getGameObject().getScaleY(), getGameObject().getRotation());
    }

    public void setState(String state) {
        if (state.equals(currentState)) return;
        this.currentAnimation = animationMap.get(state);
        this.currentState = state;
        this.stateTime = 0;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public void flip() {
        flip = !flip;
    }
}
