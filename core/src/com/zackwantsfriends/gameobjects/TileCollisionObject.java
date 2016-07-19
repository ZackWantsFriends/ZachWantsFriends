package com.zackwantsfriends.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.zackwantsfriends.components.collision.CollisionComponent;
import com.zackwantsfriends.components.collision.CollisionType;

public class TileCollisionObject extends AbstractGameObject {
    public TileCollisionObject(Rectangle collision) {
        super();

        setPosition(collision.getX(), collision.getY());
        setSize(collision.getWidth(), collision.getHeight());

        CollisionComponent collisionComponent = new CollisionComponent();
        collisionComponent.setCollisionType(CollisionType.STATIC);
        addComponent(collisionComponent);

        initialize();
    }
}
