package com.zackwantsfriends.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.zackwantsfriends.components.collision.CollisionData;

public class TextureComponent extends AbstractComponent {

    private Texture texture;

    public TextureComponent(Texture texture) {
        this.texture = texture;

    }

    @Override
    public void render(Batch batch) {
        batch.draw(texture, getGameObject().getX(), getGameObject().getY());
        super.render(batch);
    }
}
