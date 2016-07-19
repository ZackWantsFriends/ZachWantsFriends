package com.zackwantsfriends.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class AnimationDefs {
    public static Map<AnimationComponent.AnimationState, Animation> playerAnimations;

    public static void init() {
        playerAnimations = new HashMap<>();
        playerAnimations.put(AnimationComponent.AnimationState.IDLE,
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/idle_strip6.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        playerAnimations.put(AnimationComponent.AnimationState.WALKING,
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/walk_strip7.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        playerAnimations.put(AnimationComponent.AnimationState.DYING,
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/death_front_strip5.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
        playerAnimations.put(AnimationComponent.AnimationState.HUGGING,
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/hug_strip5.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
        playerAnimations.put(AnimationComponent.AnimationState.JUMPING,
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/jump_strip3.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
    }
}
