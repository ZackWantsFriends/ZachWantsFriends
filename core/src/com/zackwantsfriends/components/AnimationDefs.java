package com.zackwantsfriends.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class AnimationDefs {
    public static Map<String, Animation> playerAnimations;
    public static Map<String, Animation> humanAnimations;

    public static void init() {
        playerAnimations = new HashMap<>();
        playerAnimations.put("standing",
                new Animation(3f, new Array<>(TextureRegion.split(new Texture("zombie/idle_strip6.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        playerAnimations.put("walking",
                new Animation(2f, new Array<>(TextureRegion.split(new Texture("zombie/walk2_strip7.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        playerAnimations.put("dying_front",
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/death_front_strip5.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
        playerAnimations.put("dying_back",
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/death_back_strip3.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
        playerAnimations.put("hugging",
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/hug2_strip5.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
        playerAnimations.put("jumping",
                new Animation(0.7f, new Array<>(TextureRegion.split(new Texture("zombie/jump_strip3.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));

        humanAnimations = new HashMap<>();
        humanAnimations.put("standing",
                new Animation(3f, new Array<>(TextureRegion.split(new Texture("human/h_stand.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        humanAnimations.put("walking",
                new Animation(2f, new Array<>(TextureRegion.split(new Texture("human/h_walk_strip4.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        humanAnimations.put("startled",
                new Animation(2f, new Array<>(TextureRegion.split(new Texture("human/h_startled_strip4.png"), 32, 32)[0]),
                        Animation.PlayMode.LOOP));
        humanAnimations.put("hugged",
                new Animation(2f, new Array<>(TextureRegion.split(new Texture("human/h_hugged_strip4.png"), 32, 32)[0]),
                        Animation.PlayMode.NORMAL));
    }
}
