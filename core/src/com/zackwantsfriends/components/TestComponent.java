package com.zackwantsfriends.components;

public class TestComponent extends AbstractComponent {
    public int health = 200;
    TextureComponent textureComponent;

    @Override
    public void initialize() {
        textureComponent = getGameObject().getComponent(TextureComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        if (health > 0) {
            this.getGameObject().moveBy(1f, 0);
            health--;
        } else {
            getGameObject().setRotation(90f);
        }
    }
}
