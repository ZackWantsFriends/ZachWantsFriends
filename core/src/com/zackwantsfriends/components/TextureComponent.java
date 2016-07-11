package com.zackwantsfriends.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.zackwantsfriends.Component;

public class TextureComponent extends Component {

    private Texture texture;

    public TextureComponent() {
        texture = new Texture(Gdx.files.internal("core/assets/badlogic.jpg"));
    }

    @Override
    public void initialize() {
        super.initialize();

    }

    @Override
    public void render(Batch batch) {
        if (texture == null) return;
        batch.draw(texture, getGameObject().getX(), getGameObject().getY(), texture.getWidth(), texture.getHeight());
        super.render(batch);
    }
}
