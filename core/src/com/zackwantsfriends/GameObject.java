package com.zackwantsfriends;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.HashMap;

public class GameObject extends Actor {
    private static int nextId = 0;

    private int id;
    private String name;
    private Vector2 position;
    private float rotation;

    private HashMap<Class, Component> componentMap = new HashMap<>();

    public GameObject() {
        this.id = nextId++;
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
     * @return Returns all components
     */
    public Component[] getComponents() {
        return (Component[]) componentMap.values().toArray();
    }

    /**
     * Adds a component to the gameobject.
     *
     * @param component The type of the component.
     */
    public void addComponent(Component component) {
        componentMap.put(component.getClass(), component);
    }

    /**
     * Gets a component by its class.
     *
     * @param componentClass The class of the component.
     * @param <T>            The componenttype.
     * @return Returns the component.
     */
    public <T> T getComponent(Class<T> componentClass) {
        if (componentMap.containsKey(componentClass)) {
            return componentClass.cast(componentMap.get(componentClass));
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

    @Override
    public void act(float delta) {
        for (Component cmp : componentMap.values()) {
            cmp.update(Gdx.graphics.getDeltaTime());
        }
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        for (Component cmp : componentMap.values()) {
            cmp.render(batch);
        }
        super.draw(batch, parentAlpha);
    }
}
