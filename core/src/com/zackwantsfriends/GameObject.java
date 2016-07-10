package com.zackwantsfriends;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Christian on 10.07.2016.
 */
public class GameObject {

    private int id;
    private String name;
    private Vector2 position;
    private float rotation;

    // set to -1 because the first gameobject
    // will have the id 0.
    private static int nextId = -1;

    public GameObject() {
        nextId++;
        this.id = nextId;
        this.name = "GameObject" + id;
    }

    /**
     * Gets the id of the gameobject.
     *
     * @return Returns the id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the gameobject.
     *
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the gameobject.
     *
     * @param name The name of the gameobject.
     */
    public void setName(String name) {
        this.name = name;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
