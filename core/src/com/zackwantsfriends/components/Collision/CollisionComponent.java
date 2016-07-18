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
    }

    @Override
    public void initialize() {
        super.initialize();
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

    static public boolean intersect(Rectangle rectangle1, Rectangle rectangle2, Rectangle intersection) {
        if (rectangle1.overlaps(rectangle2)) {
            intersection.x = Math.max(rectangle1.x, rectangle2.x);
            intersection.width = Math.min(rectangle1.x + rectangle1.width, rectangle2.x + rectangle2.width) - intersection.x;
            intersection.y = Math.max(rectangle1.y, rectangle2.y);
            intersection.height = Math.min(rectangle1.y + rectangle1.height, rectangle2.y + rectangle2.height) - intersection.y;
            return true;
        }
        return false;
    }
}
