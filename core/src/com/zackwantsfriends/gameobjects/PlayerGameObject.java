package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.InputHandlerMovementComponent;
import com.zackwantsfriends.components.TextureComponent;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject() {
        super();
        setSize(32, 32);
        setOrigin(16, 16);
        // Create a new Texture component using the spritesheet "zombie.png"
        // Each tile is 32x32
        // We want it to animate, and change frames after 0.3 seconds
        TextureComponent textureComponent = new TextureComponent("zombie.png", 32, 32, true, 0.3f);
        InputHandlerMovementComponent inputHandlerMovementComponent = new InputHandlerMovementComponent();

        // Add components to game object
        addComponent(textureComponent);
        addComponent(inputHandlerMovementComponent);

        // Initialize all components
        initialize();
    }
}
