package com.colorwheel5.game.Levels;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MainMenu implements Screen {

    static final float PHONE_WIDTH = Gdx.graphics.getWidth();
    static final float PHONE_HEIGHT = Gdx.graphics.getHeight();
    private SpriteBatch batch;
    private Texture playButton;
    private Music menuMusic;
    private Game game;
    private BitmapFont fontMade;
    private BitmapFont fontPhys;
    private BitmapFont fontMob;

    public MainMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        playButton = new Texture("playbutton.png");
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("menu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        initFonts();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(playButton, PHONE_WIDTH / 2 - playButton.getWidth() / 2, PHONE_HEIGHT / 2 - playButton.getHeight() / 2);
        // fontMade.draw(batch, "made with: https://github.com/libgdx/libgdx", PHONE_WIDTH / 75, PHONE_HEIGHT / 8);
        // fontPhys.draw(batch, "physics engine: https://github.com/erincatto/Box2D", PHONE_WIDTH / 75, PHONE_HEIGHT / 10f);
        // fontMob.draw(batch, "analytics and AdMob integration: https://github.com/firebase/ ", PHONE_WIDTH / 75, PHONE_HEIGHT / 13f);
        batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            menuMusic.stop();
            Music gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
            gameMusic.setLooping(true);
            gameMusic.play();
            dispose();
        }
    }

    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = 32;
        params.color = Color.WHITE;
        fontMade = generator.generateFont(params);
        fontPhys = generator.generateFont(params);
        fontMob = generator.generateFont(params);
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
        batch.dispose();
        playButton.dispose();
        menuMusic.dispose();
        fontMade.dispose();
        fontPhys.dispose();
        fontMob.dispose();
    }
}