package com.zackwantsfriends.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent extends AbstractComponent {
    private Texture texture;
    private TextureRegion textureRegion;

    /**
     * @param path         path to the texture image
     * @param regionWidth  width in px of each region of the texture
     * @param regionHeight height in px of each region of the texture
     */
    public TextureComponent(String path, int regionWidth, int regionHeight) {
        texture = new Texture(Gdx.files.internal(path));
        textureRegion = new TextureRegion(texture, regionWidth, regionHeight);
    }

    @Override
    public void render(Batch batch) {
        if (texture == null) return;
        batch.draw(textureRegion, getGameObject().getX(), getGameObject().getY(),
                getGameObject().getOriginX(), getGameObject().getOriginY(),
                textureRegion.getRegionWidth(), textureRegion.getRegionHeight(),
                getGameObject().getScaleX(), getGameObject().getScaleY(), getGameObject().getRotation());
        super.render(batch);
    }
}
