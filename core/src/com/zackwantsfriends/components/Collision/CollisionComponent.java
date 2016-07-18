package com.zackwantsfriends.components.Collision;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.AbstractComponent;

public class CollisionComponent extends AbstractComponent {

    private CollisionType collisionType;

    public Rectangle getBounds() {
        return bounds;
    }

    private Rectangle bounds;

    public CollisionComponent() {
        collisionType = CollisionType.DYNAMIC;
    }

    @Override
    public void initialize() {
        super.initialize();
        bounds = new Rectangle(getGameObject().getX(), getGameObject().getY(),
                getGameObject().getWidth(), getGameObject().getHeight());
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

    public static boolean intersect(Rectangle r1, Rectangle r2, Rectangle intersection) {
        if (!r1.overlaps(r2)) {
            return false;
        }

        float x = Math.max(r1.x, r2.x);
        float y = Math.max(r1.y, r2.y);
        float width = Math.min(r1.x + r1.width, r2.x + r2.width) - x;
        float height = Math.min(r1.y + r1.height, r2.y + r2.height) - y;
        intersection.set(x, y, width, height);

        return true;
    }
}
