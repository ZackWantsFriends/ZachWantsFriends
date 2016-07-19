package com.zackwantsfriends.components.collision;

public class CollisionData {

    private CollisionComponent otherCollider;
    private CollisionSide collisionSide;

    public CollisionData(CollisionComponent otherCollider, CollisionSide collisionSide) {
        this.otherCollider = otherCollider;
        this.collisionSide = collisionSide;
    }

    public CollisionComponent getOtherCollider() {
        return otherCollider;
    }

    public CollisionSide getCollisionSide() {
        return collisionSide;
    }
}
