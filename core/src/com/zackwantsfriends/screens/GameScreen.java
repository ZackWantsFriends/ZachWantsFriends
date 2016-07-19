package com.zackwantsfriends.screens;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.zackwantsfriends.gameobjects.EnemyGameObject;
import com.zackwantsfriends.gameobjects.PlayerGameObject;
import com.zackwantsfriends.gameobjects.TileCollisionObject;

public class GameScreen extends AbstractScreen {
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    @Override
    public void buildStage() {
        TmxMapLoader tmxMapLoader = new TmxMapLoader(new InternalFileHandleResolver());
        TiledMap tiledMap = tmxMapLoader.load("level-3.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        // first layer should always be the object layer
        for (MapObject object : tiledMap.getLayers().get(0).getObjects()) {
            if (object.getName().equals("player_spawn")) {
                float x = ((RectangleMapObject) object).getRectangle().getX();
                float y = ((RectangleMapObject) object).getRectangle().getY();
                addActor(new PlayerGameObject(x, y));
            } else if (object.getName().equals("enemy_spawn")) {
                float x = ((RectangleMapObject) object).getRectangle().getX();
                float y = ((RectangleMapObject) object).getRectangle().getY();
                addActor(new EnemyGameObject(x, y));
            } else if (object.getName().equals("tile_collision")) {
                addActor(new TileCollisionObject(((RectangleMapObject) object).getRectangle()));
            }
        }

    }

    @Override
    public void draw() {
        tiledMapRenderer.setView((OrthographicCamera) getCamera());
        tiledMapRenderer.render();
        super.draw();
    }
}
