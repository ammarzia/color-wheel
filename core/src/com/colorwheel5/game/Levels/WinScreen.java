package com.colorwheel5.game.Levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.colorwheel5.game.Levels.MainMenu.PHONE_HEIGHT;
import static com.colorwheel5.game.Levels.MainMenu.PHONE_WIDTH;

class WinScreen implements Screen {

    private SpriteBatch spriteBatch;
    private Texture smile;
    private Game game;

    WinScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        smile = new Texture("end.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(smile, PHONE_WIDTH / 2 - smile.getWidth() / 2, PHONE_HEIGHT / 2 - smile.getHeight() / 2);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
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

    @Override
    public void dispose() {
    }
}
