package com.zackwantsfriends.components.Collision;

public class CollisionData {

    public CollisionComponent getOtherCollider() {
        return otherCollider;
    }

    public CollisionSide getCollisionSide() {
        return collisionSide;
    }

    private CollisionComponent otherCollider;
    private CollisionSide collisionSide;

    public CollisionData(CollisionComponent otherCollider, CollisionSide collisionSide) {
        this.otherCollider = otherCollider;
        this.collisionSide = collisionSide;
    }
}
