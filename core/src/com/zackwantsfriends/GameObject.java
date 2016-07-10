package com.zackwantsfriends;

import com.badlogic.gdx.assets.loaders.resolvers.ClasspathFileHandleResolver;
import com.badlogic.gdx.math.Vector2;
import com.zackwantsfriends.components.TestComponent;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Christian on 10.07.2016.
 */
public class GameObject {

    private int id;
    private String name;
    private Vector2 position;
    private float rotation;

    private HashMap<Class, Component> componentMap = new HashMap<Class, Component>();

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

    /**
     * Gets all components of the gameobject.
     *
     * @return
     */
    public Component[] getComponents() {
        return (Component[]) componentMap.values().toArray();
    }

    /**
     * Adds a component to the gameobject.
     * @param component The type of the component.
     */
    public void addComponent(Component component) {
        componentMap.put(component.getClass(), component);
    }

    /**
     * Gets a component by his class.
     * @param componentClass The class of the component.
     * @param <T> The componenttype.
     * @return Returns the component.
     */
    public <T> T getComponent(Class<T> componentClass) {
        if (componentMap.containsKey(componentClass)) {
            T result = (T) componentMap.get(componentClass);
            return result;
        }
        return null;
    }

    /**
     * Removes a component from the gameobject.
     *
     * @param componentClass The class of the component.
     * @param <T>            The type of the component.
     */
    public <T> void removeComponent(Class<T> componentClass) {
        if (componentMap.containsKey(componentClass)) {
            componentMap.remove(componentClass);
        }
    }
}
