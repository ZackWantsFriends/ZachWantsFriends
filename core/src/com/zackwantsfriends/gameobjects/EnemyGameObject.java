package com.zackwantsfriends.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.components.Collision.CollisionType;
import com.zackwantsfriends.components.InputHandlerMovementComponent;
import com.zackwantsfriends.components.AnimationComponent;
import com.zackwantsfriends.components.TextureComponent;

public class EnemyGameObject extends AbstractGameObject {

    public EnemyGameObject() {
        super();
        setPosition(200, 0);
        setSize(32, 32);
        setOrigin(16, 16);
        // Create a new Texture component using the spritesheet "zombie.png"
        // Each tile is 32x32
        // We want it to animate, and change frames after 0.1 seconds
        //AnimationComponent animationComponent = new AnimationComponent("zombie.png", 32, 32, true, 0.10f);
        //InputHandlerMovementComponent inputHandlerMovementComponent = new InputHandlerMovementComponent();

        Texture enemy = new Texture(Gdx.files.internal("zombie.png"));
        TextureComponent textureComponent = new TextureComponent(enemy);

        CollisionComponent collisionComponent = new CollisionComponent();
        collisionComponent.setCollisionType(CollisionType.STATIC);

        // Add components to game object
        addComponent(collisionComponent);
        addComponent(textureComponent);

        // Initialize all components
        initialize();
    }
}
