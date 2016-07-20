package com.zackwantsfriends.components.collision;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.AbstractComponent;

public class CollisionComponent extends AbstractComponent {
    private CollisionType collisionType;
    private Rectangle bounds;
    private Vector2 center;

    public CollisionComponent() {
        collisionType = CollisionType.DYNAMIC;
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

    public Vector2 getBoundsCenter() {
        return new Vector2(bounds.getX() + (bounds.getWidth() / 2), bounds.getY() + (bounds).getHeight() / 2);
    }

    @Override
    public void initialize() {
        bounds = new Rectangle(getGameObject().getX(), getGameObject().getY(),
                getGameObject().getWidth(), getGameObject().getHeight());
    }

    @Override
    public void update(float deltaTime) {
        bounds.setPosition(getGameObject().getX(), getGameObject().getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public CollisionType getCollisionType() {
        return collisionType;
    }

    public void setCollisionType(CollisionType collisionType) {
        this.collisionType = collisionType;
    }
}
