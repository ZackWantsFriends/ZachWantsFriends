package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.AnimationComponent;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.components.InputHandlerMovementComponent;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject() {
        super();
        setName("PLAYER");
        setPosition(0, 0);
        setSize(32, 32);
        setOrigin(16, 16);
        // Create a new Texture component using the spritesheet "zombie.png"
        // Each tile is 32x32
        // We want it to animate, and change frames after 0.1 seconds
        AnimationComponent animationComponent = new AnimationComponent("zombie/idle_strip6.png", 32, 32, true, 0.10f);
        InputHandlerMovementComponent inputHandlerMovementComponent = new InputHandlerMovementComponent();

        // Add components to game object
        addComponent(new CollisionComponent());
        addComponent(animationComponent);
        addComponent(inputHandlerMovementComponent);

        // Initialize all components
        initialize();
    }
}
