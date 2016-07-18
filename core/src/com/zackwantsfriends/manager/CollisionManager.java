package com.zackwantsfriends.manager;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.components.Collision.CollisionType;
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
                        Rectangle intersection = new Rectangle(0, 0, 0, 0);
                        Intersector.intersectRectangles(currentCollider.getBounds(), nextCollider.getBounds(), intersection);

                        CollisionType collisionType = nextCollider.getCollisionType();

                        System.out.println(collisionType);


                        // Intersection with the right side
                        if (intersection.getX() > currentCollider.getBounds().getX()) {
                            switch (collisionType) {
                                case DYNAMIC:
                                    nextCollider.getGameObject().moveBy(intersection.getWidth(), 0);
                                    break;
                                case STATIC:
                                    currentCollider.getGameObject().moveBy(-intersection.getWidth(), 0);
                                    break;
                            }
                        }

                        // Intersection with the top side
                        if (intersection.getY() > currentCollider.getBounds().getY()) {

                        }

                        // Intersection with the left side
                        if (intersection.getX() + intersection.getWidth() < currentCollider.getBounds().getX() + currentCollider.getBounds().getWidth()) {
                            switch (collisionType) {
                                case DYNAMIC:
                                    nextCollider.getGameObject().moveBy(-intersection.getWidth(), 0);
                                    break;
                                case STATIC:
                                    currentCollider.getGameObject().moveBy(intersection.getWidth(), 0);
                                    break;
                            }

                        }

                        // Intersection with the bottom side
                        if (intersection.getY() + intersection.getHeight() < currentCollider.getBounds().getY() + currentCollider.getBounds().getHeight()) {

                        }
                    }
                }

            }
        }

    }

}
