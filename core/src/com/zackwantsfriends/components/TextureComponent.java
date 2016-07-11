package com.zackwantsfriends.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent extends AbstractComponent {
    private Texture texture;
    private TextureRegion[][] textureRegions;
    private boolean animate;
    private float timePerFrame;

    private int currentFrame;
    private float timeOnFrame;

    /**
     * @param path         path to the texture image
     * @param regionWidth  width in px of each region of the texture
     * @param regionHeight height in px of each region of the texture
     */
    public TextureComponent(String path, int regionWidth, int regionHeight, boolean animate, float timePerFrame) {
        texture = new Texture(Gdx.files.internal(path));
        textureRegions = TextureRegion.split(texture, regionWidth, regionHeight);
        this.animate = animate;
        this.timePerFrame = timePerFrame;

        // set current frame to 0
        currentFrame = 0;
    }

    public void setAnimate(boolean animate) {
        this.animate = animate;
    }

    @Override
    public void update(float deltaTime) {
        if (animate) {
            if (timeOnFrame > timePerFrame) {   // check if it's time to go to the next frame yet
                currentFrame = ++currentFrame % textureRegions[0].length;
                timeOnFrame = 0;
            } else {                            // add to the time counter
                timeOnFrame += deltaTime;
            }
        }
    }

    @Override
    public void render(Batch batch) {
        if (textureRegions[0][currentFrame] == null) return;
        // draw the texture region corresponding to the current frame
        batch.draw(textureRegions[0][currentFrame], getGameObject().getX(), getGameObject().getY(),
                getGameObject().getOriginX(), getGameObject().getOriginY(),
                textureRegions[0][currentFrame].getRegionWidth(), textureRegions[0][currentFrame].getRegionHeight(),
                getGameObject().getScaleX(), getGameObject().getScaleY(), getGameObject().getRotation());
    }
}
