package com.colorwheel5.game;

import com.badlogic.gdx.Game;
import com.colorwheel5.game.Levels.MainMenu;

class ColorWheel5 extends Game {

    private Game game;

    ColorWheel5() {
        game = this;
    }

    @Override
    public void create() {
        setScreen(new MainMenu(this));
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}