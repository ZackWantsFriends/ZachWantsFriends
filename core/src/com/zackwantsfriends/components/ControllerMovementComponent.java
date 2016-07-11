package com.zackwantsfriends.components;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class ControllerMovementComponent extends AbstractComponent {
    @Override
    public boolean keyDown(InputEvent event, int keycode) {
        System.out.println(keycode);
        return super.keyDown(event, keycode);
    }
}
