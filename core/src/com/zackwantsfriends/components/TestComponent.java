package com.zackwantsfriends.components;

import com.zackwantsfriends.Component;

public class TestComponent extends Component {

    public int health = 200;

    @Override
    public void update(float deltaTime) {

        this.getGameObject().moveBy(2f, 0);

        super.update(deltaTime);
    }
}
