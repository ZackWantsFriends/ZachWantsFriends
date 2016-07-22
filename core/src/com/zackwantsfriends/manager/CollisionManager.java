package com.zackwantsfriends.manager;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.PhysicsComponent;
import com.zackwantsfriends.components.collision.CollisionComponent;
import com.zackwantsfriends.components.collision.CollisionData;
import com.zackwantsfriends.components.collision.CollisionSide;
import com.zackwantsfriends.components.collision.CollisionType;
import com.zackwantsfriends.gameobjects.AbstractGameObject;
import com.zackwantsfriends.util.QuadRectangle;
import com.zackwantsfriends.util.QuadTree;

import java.util.ArrayList;

public class CollisionManager {

    private QuadTree<CollisionComponent> quadTree;

    public CollisionManager() {
        quadTree = new QuadTree<>(new QuadRectangle(0, 0, 0, 0), 0);
        QuadTree.maxItemByNode = 20;
        QuadTree.maxLevel = 10;
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

                        // using the fancy Minkowski addition
                        // http://gamedev.stackexchange.com/questions/24078/which-side-was-hit/24091#24091
                        float wy = (currentCollider.getBounds().getWidth() + nextCollider.getBounds().getWidth()) * (currentCollider.getBoundsCenter().y - nextCollider.getBoundsCenter().y);
                        float hx = (currentCollider.getBounds().getHeight() + nextCollider.getBounds().getHeight()) * (currentCollider.getBoundsCenter().x - nextCollider.getBoundsCenter().x);

                        // default collision side
                        CollisionSide collisionSide = CollisionSide.TOP;

                        // gets the type of the collider
                        CollisionType collisionType = nextCollider.getCollisionType();

                        if(!(currentCollider.getCollisionType().equals(CollisionType.TRIGGER) ||
                                nextCollider.getCollisionType().equals(CollisionType.TRIGGER))) {
                            if (wy > hx) {
                                // Collision with the Bottom-Side
                                if (wy > -hx) {
                                    switch (collisionType) {
                                        case DYNAMIC:
                                            //nextCollider.getGameObject().moveBy(0, -intersection.getHeight());
                                            break;
                                        case STATIC:
                                            currentCollider.getGameObject().moveBy(0, intersection.getHeight());
                                            break;
                                    }
                                    collisionSide = CollisionSide.BOTTOM;
                                }
                                // Collision with the Left-Side
                                else {
                                    switch (collisionType) {
                                        case DYNAMIC:
                                            nextCollider.getGameObject().moveBy(intersection.getWidth(), 0);
                                            break;
                                        case STATIC:
                                            currentCollider.getGameObject().moveBy(-intersection.getWidth(), 0);
                                            break;
                                    }
                                    collisionSide = CollisionSide.LEFT;
                                }
                            } else {
                                // Collision with the Right-Side
                                if (wy > -hx) {
                                    switch (collisionType) {
                                        case DYNAMIC:
                                            nextCollider.getGameObject().moveBy(-intersection.getWidth(), 0);
                                            break;
                                        case STATIC:
                                            currentCollider.getGameObject().moveBy(intersection.getWidth(), 0);
                                            break;
                                    }
                                    collisionSide = CollisionSide.RIGHT;
                                }
                                // Collision with the Top-Side
                                else {
                                    switch (collisionType) {
                                        case DYNAMIC:
                                            nextCollider.getGameObject().moveBy(0, intersection.getHeight());
                                            break;
                                        case STATIC:
                                            currentCollider.getGameObject().moveBy(0, -intersection.getHeight());
                                            break;
                                    }
                                    collisionSide = CollisionSide.TOP;
                                }
                            }
                        }

                        // notify every component of the gameobject that a collision took place.
                        for (int i = 0; i < currentCollider.getGameObject().getComponents().length; i++) {
                            currentCollider.getGameObject().getComponents()[i].onCollision(new CollisionData(nextCollider, collisionSide));
                        }
                    }
                }

            }
        }

    }

}
