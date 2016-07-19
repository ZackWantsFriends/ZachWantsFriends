package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.AnimationComponent;
import com.zackwantsfriends.components.AnimationDefs;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.components.Collision.CollisionType;
import com.zackwantsfriends.components.InputHandlerMovementComponent;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject() {
        super();
        setName("PLAYER");
        setPosition(0, 0);
        setSize(32, 32);
        setOrigin(16, 16);

        AnimationComponent animationComponent = new AnimationComponent(AnimationDefs.playerAnimations, AnimationComponent.AnimationState.IDLE, false);
        InputHandlerMovementComponent inputHandlerMovementComponent = new InputHandlerMovementComponent();
        CollisionComponent collisionComponent = new CollisionComponent();
        collisionComponent.setCollisionType(CollisionType.TRIGGER);

        // Add components to game object
        addComponent(collisionComponent);
        addComponent(animationComponent);
        addComponent(inputHandlerMovementComponent);

        // Initialize all components
        initialize();
    }
}
