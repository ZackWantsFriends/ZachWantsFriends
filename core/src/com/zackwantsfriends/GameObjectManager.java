package com.zackwantsfriends;

import java.util.HashMap;

public class GameObjectManager {

    //TODO: GameObject events (added, removed)

    private HashMap<Integer, GameObject> gameObjectMap;

    public GameObjectManager() {
        gameObjectMap = new HashMap<>();
    }

    /**
     * Adds a gameobject to the gameobjectmanager.
     *
     * @param gameObject The gameobject.
     */
    public void addGameObject(GameObject gameObject) {

        if (gameObject != null || gameObjectMap.containsKey(gameObject.getId())) return;
        gameObjectMap.put(gameObject.getId(), gameObject);

        // Initializes all components after adding it to the
        // gameobjectmanager. So you have access
        // to every component in the initialize-method.
        for (Component component : gameObject.getComponents()) {
            component.initialize();
        }

        // maybe fire an event?
        // GameObject added?
    }

    /**
     * Gets a gameobject from the gameobjectmanager.
     *
     * @param id The id of the gameobject.
     * @return Returns the gameobject.
     */
    public GameObject getGameObject(int id) {
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
