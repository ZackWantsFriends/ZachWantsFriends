package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.TestComponent;
import com.zackwantsfriends.components.TextureComponent;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject() {
        super();
        // Create a new Texture component using the spritesheet "zombie.png"
        // Each tile is 32x32
        // We want it to animate, and change frames after 0.3 seconds
        TextureComponent textureComponent = new TextureComponent("zombie.png", 32, 32, true, 0.3f);
        TestComponent testComponent = new TestComponent();
        addComponent(textureComponent);
        addComponent(testComponent);
        initialize();
    }
}
