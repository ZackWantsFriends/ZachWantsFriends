package com.zackwantsfriends.components;

import com.zackwantsfriends.gameobjects.AbstractGameObject;

public class HealthComponent extends AbstractGameObject {

    private float health;

    public HealthComponent() {
        health = 100;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

}
