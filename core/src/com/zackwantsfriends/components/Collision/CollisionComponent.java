package com.zackwantsfriends.components.Collision;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.AbstractComponent;

public class CollisionComponent extends AbstractComponent {

    private CollisionType collisionType;
    private Rectangle bounds;

    public CollisionComponent() {
        bounds = new Rectangle(getGameObject().getX(), getGameObject().getY(),
                getGameObject().getWidth(), getGameObject().getHeight());

        collisionType = CollisionType.DYNAMIC;
    }

    public CollisionType getCollisionType() {
        return collisionType;
    }

    public void setCollisionType(CollisionType collisionType) {
        this.collisionType = collisionType;
    }

    @Override
    public void update(float deltaTime) {
        bounds.setPosition(getGameObject().getX(), getGameObject().getY());
    }
}
