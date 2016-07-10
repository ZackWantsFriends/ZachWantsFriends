package com.zackwantsfriends;

import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

class GameObject {
    private static int nextId = 0;
    private int id;
    private String name;
    private Vector2 position;
    private float rotation;
    private Map<Class<? extends Component>, Component> componentList;

    public GameObject() {
        this.id = nextId++;
        this.name = "GameObject" + id;
        position = new Vector2();
        componentList = new HashMap<>();
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
     * @return Returns position of GameObject
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * @param position New position
     */
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    /**
     * @return rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation new rotation
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @param component component to add
     */
    public void addComponent(Component component) {
        if (!componentList.containsValue(component)) {
            component.setGameObject(this);
            componentList.put(component.getClass(), component);
        }
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        if (componentList.containsKey(componentClass)) {
            return componentClass.cast(componentList.get(componentClass));
        }
        return null;
    }

}
