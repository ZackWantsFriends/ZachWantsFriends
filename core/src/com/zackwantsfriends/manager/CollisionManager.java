package com.zackwantsfriends.manager;

import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;

public class CollisionManager {


    public void update(AbstractGameObject gameObject) {

        if (gameObject.getComponent(CollisionComponent.class) == null) return;

        CollisionComponent collisionCmp = gameObject.getComponent(CollisionComponent.class);


    }

}
