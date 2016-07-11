package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.TestComponent;
import com.zackwantsfriends.components.TextureComponent;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject() {
        super();
        TextureComponent textureComponent = new TextureComponent("player_test2.png", 14, 32);
        addComponent(textureComponent);
        addComponent(new TestComponent());
    }
}
