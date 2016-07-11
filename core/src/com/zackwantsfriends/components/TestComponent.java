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
        if (health > 0) {   // if player has health, move left 1 px
            this.getGameObject().moveBy(1f, 0);
            health--;
        } else {            // if player reaches 0 health, die
            getGameObject().setRotation(90f);
            textureComponent.setAnimate(false);
        }
    }
}
