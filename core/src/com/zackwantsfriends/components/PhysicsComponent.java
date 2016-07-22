package com.zackwantsfriends.components;

import com.zackwantsfriends.components.collision.CollisionData;
import com.zackwantsfriends.components.collision.CollisionSide;
import com.zackwantsfriends.components.collision.CollisionType;

public class PhysicsComponent extends AbstractComponent {
    final float GRAVITY = -0.1f;
    final float MAX_VELX = 5f;
    final float MAX_VELY = 5f;

    private AnimationComponent animationComponent;

    private float velX;
    private float velY;
    boolean onGround;

    @Override
    public void initialize() {
        animationComponent = getGameObject().getComponent(AnimationComponent.class);
    }

    @Override
    public void onCollision(CollisionData collisionData) {
        if(collisionData.getOtherCollider().getCollisionType().equals(CollisionType.TRIGGER)) {
            return;
        }

        if (collisionData.getCollisionSide().equals(CollisionSide.BOTTOM)) {
            velY = 0;
            onGround = true;
        } else if (collisionData.getCollisionSide().equals(CollisionSide.TOP)) {
            velY = 0;
        }
    }

    @Override
    public void update(float deltaTime) {
        velY += GRAVITY;
        velX *= 0.9;
        if (Math.abs(velX) < 0.1) velX = 0;
        getGameObject().moveBy(velX * deltaTime, velY * deltaTime);
        if (velY > 0) {
            animationComponent.setState("jumping");
            onGround = false;
        } else if(velY < 0) {
            animationComponent.setState("standing"); //TODO: change to "falling" when we have the animation for that
        }
    }

    public void addForce(float x, float y) {
        velX += x;
        velY += y;
    }
}
