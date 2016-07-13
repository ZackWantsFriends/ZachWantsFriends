package com.zackwantsfriends.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.zackwantsfriends.components.AbstractComponent;
import com.zackwantsfriends.components.Collision.CollisionComponent;
import com.zackwantsfriends.gameobjects.AbstractGameObject;
import com.zackwantsfriends.manager.CollisionManager;

public abstract class AbstractScreen extends Stage implements Screen {

    private CollisionManager collisionManager;

    protected AbstractScreen() {
        super(new StretchViewport(640, 360, new OrthographicCamera()));
        Gdx.input.setInputProcessor(new InputMultiplexer(this));

        collisionManager = new CollisionManager();
    }
    // Load actors in this method
    public abstract void buildStage();

    public void addActor(AbstractGameObject gameObject) {
        getActors().add(gameObject);

        if (gameObject.getComponent(CollisionComponent.class) != null) {
            collisionManager.addCollider(gameObject.getComponent(CollisionComponent.class));
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Calling to Stage methods
        super.act(delta);
        super.draw();
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
