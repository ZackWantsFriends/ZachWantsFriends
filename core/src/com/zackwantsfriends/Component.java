package com.zackwantsfriends;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Component {

    private GameObject gameObject;
    private boolean active;

    /**
     * Whether or not the component is currently active.
     *
     * @return Returns true or false.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Toggle the activity of the component.
     *
     * @param active new active state
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the gameobject that the component is attached to.
     *
     * @return Returns the attached gameobject.
     */
    public GameObject getGameObject() {
        return gameObject;
    }

    /**
     * Sets the gameobject of the component.
     *
     * @param gameObject The gameobject.
     */
    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    /**
     * Initializes the component.
     * Use this method to get other components from the gameobject.
     */
    public void initialize() {
    }

    /**
     * Renders the component.
     *
     * @param batch The spritebatch.
     * @param delta The deltatime.
     */
    public void render(SpriteBatch batch, float delta) {

    }

}
