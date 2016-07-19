package com.zackwantsfriends.gameobjects;

import com.zackwantsfriends.components.AnimationComponent;
import com.zackwantsfriends.components.AnimationDefs;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.components.Collision.CollisionType;

public class EnemyGameObject extends AbstractGameObject {

    public EnemyGameObject() {
        super();
        setName("ENEMY");
        setPosition(200, 0);
        setSize(32, 32);
        setOrigin(16, 16);

        AnimationComponent animationComponent = new AnimationComponent(AnimationDefs.playerAnimations, AnimationComponent.AnimationState.IDLE, false);

        CollisionComponent collisionComponent = new CollisionComponent();
        collisionComponent.setCollisionType(CollisionType.TRIGGER);

        // Add components to game object
        addComponent(collisionComponent);
        addComponent(animationComponent);

        // Initialize all components
        initialize();
    }
}
