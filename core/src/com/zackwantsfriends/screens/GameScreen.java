package com.zackwantsfriends.screens;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.zackwantsfriends.gameobjects.EnemyGameObject;
import com.zackwantsfriends.gameobjects.PlayerGameObject;

public class GameScreen extends AbstractScreen {
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    @Override
    public void buildStage() {
        PlayerGameObject player = new PlayerGameObject();
        this.addActor(player);
        this.addActor(new EnemyGameObject());

        TmxMapLoader tmxMapLoader = new TmxMapLoader(new InternalFileHandleResolver());
        TiledMap tiledMap = tmxMapLoader.load("level-1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    @Override
    public void draw() {
        tiledMapRenderer.setView((OrthographicCamera) getCamera());
        tiledMapRenderer.render();
        super.draw();
    }
}
