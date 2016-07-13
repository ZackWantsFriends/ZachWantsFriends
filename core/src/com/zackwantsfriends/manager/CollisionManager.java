package com.zackwantsfriends.manager;

import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;
import com.zackwantsfriends.util.QuadRectangle;
import com.zackwantsfriends.util.QuadTree;

public class CollisionManager {

    private QuadTree<CollisionComponent> quadTree;

    public CollisionManager() {
        quadTree = new QuadTree<CollisionComponent>(new QuadRectangle(0, 0, 0, 0), 0);
        quadTree.maxItemByNode = 20;
        quadTree.maxLevel = 10;
    }

    public void update(AbstractGameObject gameObject) {

        if (gameObject.getComponent(CollisionComponent.class) == null) return;

        CollisionComponent collisionCmp = gameObject.getComponent(CollisionComponent.class);


    }

}
