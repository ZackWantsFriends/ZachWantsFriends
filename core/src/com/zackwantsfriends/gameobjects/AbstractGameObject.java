package com.zackwantsfriends.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.zackwantsfriends.components.AbstractComponent;

import java.util.HashMap;

public class AbstractGameObject extends Actor {
    private static int nextId = 0;

    private int id;
    private String name;

    private HashMap<Class, AbstractComponent> componentMap = new HashMap<>();

    public AbstractGameObject() {
        this.id = nextId++;
        this.name = "AbstractGameObject" + id;
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

    /**
     * Gets all components of the gameobject.
     *
     * @return Returns all components
     */
    public AbstractComponent[] getComponents() {
        return (AbstractComponent[]) componentMap.values().toArray();
    }

    /**
     * Adds a component to the gameobject.
     *
     * @param component The type of the component.
     */
    public void addComponent(AbstractComponent component) {
        componentMap.put(component.getClass(), component);
        component.setGameObject(this);
        addListener(component);
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

    /**
     * Initialize all owned components
     */
    public void initialize() {
        for (AbstractComponent cmp : componentMap.values()) {
            cmp.initialize();
        }
    }

    @Override
    public void act(float delta) {
        for (AbstractComponent cmp : componentMap.values()) {
            if (cmp.isActive()) {
                cmp.update(Gdx.graphics.getDeltaTime());
            }
        }
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        for (AbstractComponent cmp : componentMap.values()) {
            if (cmp.isActive()) {
                cmp.render(batch);
            }

        }
        super.draw(batch, parentAlpha);
    }
}
