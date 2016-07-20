package com.zackwantsfriends.screens;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.zackwantsfriends.TheGame;
import com.zackwantsfriends.components.collision.CollisionComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;
import com.zackwantsfriends.gameobjects.EnemyGameObject;
import com.zackwantsfriends.gameobjects.PlayerGameObject;
import com.zackwantsfriends.gameobjects.TileCollisionObject;

import java.util.Objects;

public class GameScreen extends AbstractScreen {
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private ShapeRenderer debugRenderer;
    private PlayerGameObject playerGameObject;

    @Override
    public void buildStage() {
        TmxMapLoader tmxMapLoader = new TmxMapLoader(new InternalFileHandleResolver());
        TiledMap tiledMap = tmxMapLoader.load("level-3.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        debugRenderer = new ShapeRenderer();
        debugRenderer.setProjectionMatrix(getCamera().combined);

        // first layer should always be the object layer
        for (MapObject object : tiledMap.getLayers().get(0).getObjects()) {
            if (Objects.equals(object.getName(), "player_spawn")) {
                float x = ((RectangleMapObject) object).getRectangle().getX();
                float y = ((RectangleMapObject) object).getRectangle().getY();
                playerGameObject = new PlayerGameObject(x, y);
                addActor(playerGameObject);
            } else if (Objects.equals(object.getName(), "enemy_spawn")) {
                float x = ((RectangleMapObject) object).getRectangle().getX();
                float y = ((RectangleMapObject) object).getRectangle().getY();
                addActor(new EnemyGameObject(x, y));
            } else if (Objects.equals(object.getName(), "tile_collision")) {
                addActor(new TileCollisionObject(((RectangleMapObject) object).getRectangle()));
            }
        }
    }

    @Override
    public void draw() {
        tiledMapRenderer.setView((OrthographicCamera) getCamera());
        tiledMapRenderer.render();
        super.draw();

        if (playerGameObject != null) {
            //getCamera().lookAt(playerGameObject.getX(), playerGameObject.getY(), getCamera().position.z);
        }

        // debug renderer renders collision bounds
        if (TheGame.DEBUG) {
            debugRenderer.begin(ShapeRenderer.ShapeType.Line);
            debugRenderer.setColor(Color.RED);
            for (Actor actor : getActors()) {
                AbstractGameObject gameObject = (AbstractGameObject) actor;
                if (gameObject.getComponent(CollisionComponent.class) != null) {
                    Rectangle collision = gameObject.getComponent(CollisionComponent.class).getBounds();
                    debugRenderer.rect(collision.x, collision.y, collision.width, collision.height);
                }
            }
            debugRenderer.end();
        }
    }
}
