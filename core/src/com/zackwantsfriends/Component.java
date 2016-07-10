package com.zackwantsfriends;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Christian on 10.07.2016.
 */
public abstract class Component {

    private GameObject gameObject;

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
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;

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
     * Renders the component.
     * @param batch The spritebatch.
     * @param delta The deltatime.
     */
    public void render(SpriteBatch batch, float delta) {
    }

}
