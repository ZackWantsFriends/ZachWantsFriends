package com.zackwantsfriends;

import com.zackwantsfriends.components.AbstractComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;

import java.util.HashMap;

public class GameObjectManager {

    //TODO: AbstractGameObject events (added, removed)

    private HashMap<Integer, AbstractGameObject> gameObjectMap;

    public GameObjectManager() {
        gameObjectMap = new HashMap<>();
    }

    /**
     * Gets all gameobjects in the gameobjectmanager.
     *
     * @return Returns all gameobjects.
     */
    public AbstractGameObject[] getGameObjects() {
        return (AbstractGameObject[]) gameObjectMap.values().toArray();
    }

    /**
     * Adds a gameobject to the gameobjectmanager.
     *
     * @param gameObject The gameobject.
     */
    public void addGameObject(AbstractGameObject gameObject) {

        if (gameObject != null || gameObjectMap.containsKey(gameObject.getId())) return;
        gameObjectMap.put(gameObject.getId(), gameObject);

        // Initializes all components after adding it to the
        // gameobjectmanager. So you have access
        // to every component in the initialize-method.
        for (AbstractComponent component : gameObject.getComponents()) {
            component.initialize();
        }

        // maybe fire an event?
        // AbstractGameObject added?
    }

    /**
     * Gets a gameobject from the gameobjectmanager.
     *
     * @param id The id of the gameobject.
     * @return Returns the gameobject.
     */
    public AbstractGameObject getGameObject(int id) {
        if (gameObjectMap.containsKey(id)) {
            return gameObjectMap.get(id);
        }
        return null;
    }

    /**
     * Removes a gameobject from the gameobjectmanager.
     *
     * @param id The id of the gameobject.
     */
    public void removeGameObject(int id) {
        if (!gameObjectMap.containsKey(id)) return;

        // maybe fire an event?
        // GameObjectRemoved?
        gameObjectMap.remove(id);
    }
}
