package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.AnimationComponent;
import com.zackwantsfriends.components.AnimationDefs;
import com.zackwantsfriends.components.InputHandlerMovementComponent;
import com.zackwantsfriends.components.collision.CollisionComponent;
import com.zackwantsfriends.components.collision.CollisionType;

public class PlayerGameObject extends AbstractGameObject {
    public PlayerGameObject(float x, float y) {
        super();
        setName("PLAYER");
        setPosition(x, y);
        setSize(32, 32);
        setOrigin(16, 16);

        AnimationComponent animationComponent = new AnimationComponent(AnimationDefs.playerAnimations, AnimationComponent.AnimationState.IDLE, false);
        InputHandlerMovementComponent inputHandlerMovementComponent = new InputHandlerMovementComponent();
        CollisionComponent collisionComponent = new CollisionComponent();
        collisionComponent.setCollisionType(CollisionType.DYNAMIC);

        // Add components to game object
        addComponent(collisionComponent);
        addComponent(animationComponent);
        addComponent(inputHandlerMovementComponent);

        // Initialize all components
        initialize();
    }
}
