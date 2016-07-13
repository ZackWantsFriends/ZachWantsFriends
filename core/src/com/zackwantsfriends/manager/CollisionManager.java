package com.zackwantsfriends.manager;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;
import com.zackwantsfriends.util.QuadRectangle;
import com.zackwantsfriends.util.QuadTree;

import java.util.ArrayList;

public class CollisionManager {

    private QuadTree<CollisionComponent> quadTree;

    public CollisionManager() {
        quadTree = new QuadTree<CollisionComponent>(new QuadRectangle(0, 0, 0, 0), 0);
        quadTree.maxItemByNode = 20;
        quadTree.maxLevel = 10;
    }

    public void addCollider(CollisionComponent collisionCmp) {
        if (collisionCmp == null) return;
        quadTree.insert(new QuadRectangle(collisionCmp.getBounds().getX(), collisionCmp.getBounds().getY(), collisionCmp.getBounds().getWidth(), collisionCmp.getBounds().getHeight()), collisionCmp);
    }

    public void update(AbstractGameObject gameObject) {

        // check if gamobject owns a collision component
        if (gameObject.getComponent(CollisionComponent.class) == null) return;

        CollisionComponent collisionCmp = gameObject.getComponent(CollisionComponent.class);

        // gets all collisioncomponents in the area of the gameobject.
        ArrayList<CollisionComponent> list = new ArrayList<>();
        QuadRectangle rec = new QuadRectangle(collisionCmp.getBounds().getX(), collisionCmp.getBounds().getY(), collisionCmp.getBounds().getWidth(), collisionCmp.getBounds().getHeight());
        quadTree.getElements(list, rec);

        // check if the gameobject collides with other collider.
        for (CollisionComponent currentCollider : list) {
            for (CollisionComponent nextCollider : list) {

                if (currentCollider != nextCollider) {

                    if (Intersector.overlaps(currentCollider.getBounds(), nextCollider.getBounds())) {

                        // gets the overlapping rectangle to resolve the collision
                        Rectangle intersection = null;
                        Intersector.intersectRectangles(collisionCmp.getBounds(), nextCollider.getBounds(), intersection);

                        //TODO: RESOLVE COLLISION
                    }

                }

            }
        }

    }

}
