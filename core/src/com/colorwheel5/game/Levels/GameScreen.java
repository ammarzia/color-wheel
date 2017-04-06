package com.colorwheel5.game.Levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.math.BigDecimal;

import static com.colorwheel5.game.Levels.MainMenu.PHONE_HEIGHT;
import static com.colorwheel5.game.Levels.MainMenu.PHONE_WIDTH;

class GameScreen implements Screen, GestureDetector.GestureListener {

    private static final float FPSCAP = 1 / 375F;
    private SpriteBatch spriteBatch;
    private SpriteBatch textureBatch;
    private Sprite wheelSprite;
    private Sprite ballSprite;
    private Texture numberTexture;
    private Body body;
    private Body body2;
    private World world;
    private Camera camera;
    // Box2DDebugRenderer box2DDebugRenderer;
    private Viewport viewport;
    private static int levelCounter = 1; // 24 20
    private static int highscore = 0;
    private float accumulator = 1;
    private Game game;

    GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        world = new World(new Vector2(0, 0), true);
        camera = new OrthographicCamera();
        viewport = new StretchViewport(PHONE_WIDTH, PHONE_HEIGHT, camera);

        // box2DDebugRenderer = new Box2DDebugRenderer();

        GestureDetector gestureDetector;
        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);

        switch (levelCounter) {
            case 1:
                createSprites("lv1.png", "ball1.png");
                createWheel("5E+10", false);
                createNumber("1.png");
                break;
            case 2:
                createSprites("lv2.png", "ball2.png");
                createWheel("8E+10", false);
                createNumber("2.png");
                break;
            case 3:
                createSprites("lv3.png", "ball3.png");
                createWheel("10E+10", true);
                createNumber("3.png");
                break;
            case 4:
                createSprites("lv4.png", "ball4.png");
                createWheel("13E+10", false);
                createNumber("4.png");
                break;
            case 5:
                createSprites("lv5.png", "ball5.png");
                createWheel("15E+10", true);
                createNumber("5.png");
                break;
            case 6:
                createSprites("lv6.png", "ball6.png");
                createWheel("15E+10", true);
                createNumber("6.png");
                break;
            case 7:
                createSprites("lv7.png", "ball7.png");
                createWheel("20E+10", false);
                createNumber("7.png");
                break;
            case 8:
                createSprites("lv8.png", "ball8.png");
                createWheel("20E+10", true);
                createNumber("8.png");
                break;
            case 9:
                createSprites("lv9.png", "ball9.png");
                createWheel("15E+10", false);
                createNumber("9.png");
                break;
            case 10:
                createSprites("lv10.png", "ball10.png");
                createWheel("25E+10", false);
                createNumber("10.png");
                break;
            case 11:
                createSprites("lv11.png", "ball11.png");
                createWheel("30E+10", true);
                createNumber("11.png");
                break;
            case 12:
                createSprites("lv12.png", "ball12.png");
                createWheel("35E+10", false);
                createNumber("12.png");
                break;
            case 13:
                createSprites("lv13.png", "ball13.png");
                createWheel("35E+10", true);
                createNumber("13.png");
                break;
            case 14:
                createSprites("lv14.png", "ball14.png");
                createWheel("45E+10", true);
                createNumber("14.png");
                break;
            case 15:
                createSprites("lv15.png", "ball15.png");
                createWheel("50E+10", false);
                createNumber("15.png");
                break;
            case 16:
                createSprites("lv16.png", "ball16.png");
                createWheel("55E+10", false);
                createNumber("16.png");
                break;
            case 17:
                createSprites("lv17.png", "ball17.png");
                createWheel("15E+10", true);
                createNumber("17.png");
                break;
            case 18:
                createSprites("lv18.png", "ball18.png");
                createWheel("15E+10", true);
                createNumber("18.png");
                break;
            case 19:
                createSprites("lv19.png", "ball19.png");
                createWheel("30E+10", false);
                createNumber("19.png");
                break;
            case 20:
                createSprites("lv20.png", "ball20.png");
                createWheel("50E+10", true);
                createNumber("20.png");
                break;
            case 21:
                createSprites("lv21.png", "ball21.png");
                createWheel("60E+10", true);
                createNumber("21.png");
                break;
            case 22:
                createSprites("lv22.png", "ball22.png");
                createWheel("65E+10", false);
                createNumber("22.png");
                break;
            case 23:
                createSprites("lv23.png", "ball23.png");
                createWheel("65E+10", false);
                createNumber("23.png");
                break;
            case 24:
                createSprites("lv24.png", "ball24.png");
                createWheel("85E+10", true);
                createNumber("24.png");
                break;
            default:
                assert false : "Invalid level!";
        }

        createBall();
        createCollisionListener();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // box2DDebugRenderer.render(world, camera.combined);

        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);
        for (Body b : bodies) {
            if (b.getUserData() != null && b.getUserData() instanceof Sprite && b.equals(body)) {
                Sprite sprite = (Sprite) b.getUserData();
                sprite.setPosition(-wheelSprite.getWidth() / 2, -wheelSprite.getHeight() / 2);
                sprite.setRotation(MathUtils.radiansToDegrees * b.getAngle());
                sprite.draw(spriteBatch);
            } else {
                Sprite sprite = (Sprite) b.getUserData();
                sprite.setPosition(-ballSprite.getWidth() / 2, b.getPosition().y);
                sprite.setRotation(MathUtils.radiansToDegrees * b.getAngle());
                sprite.draw(spriteBatch);
            }
        }
        spriteBatch.end();

        textureBatch.begin();
        textureBatch.draw(numberTexture, PHONE_WIDTH / 2 - numberTexture.getWidth() / 2, PHONE_HEIGHT / 2 - numberTexture.getHeight() / 2);
        textureBatch.end();

        accumulator += delta;
        while (accumulator > FPSCAP) {
            world.step(FPSCAP, 6, 2);
            accumulator -= FPSCAP;
        }
    }

    private int getHighScore() {
        Preferences prefs = Gdx.app.getPreferences("My Preferences");
        if (levelCounter > highscore) {
            highscore = levelCounter;
            prefs.putInteger("highscore", highscore);
            prefs.flush();
        }
        return prefs.getInteger("highscore", highscore);
    }

    private void createSprites(String customWheelImage, String customBallImage) {
        spriteBatch = new SpriteBatch();
        wheelSprite = new Sprite(new Texture(customWheelImage));
        ballSprite = new Sprite(new Texture(customBallImage));
    }

    private void createNumber(String customNumberImage) {
        textureBatch = new SpriteBatch();
        numberTexture = new Texture(customNumberImage);
    }

    private void createWheel(String customSpeed, boolean isClockwise) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0, 0);
        body = world.createBody(bodyDef);

        CircleShape circle = new CircleShape();
        circle.setRadius(350);
        if (levelCounter >= 9) {
            circle.setRadius(375);
        }

        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 1;
        fd.friction = 0;
        fd.restitution = 0;
        body.createFixture(fd);

        float[] vertices = new float[]{15, -380, 80, -370, 150, -350, 180, -370, 210, -325, 250, -290, 280, -265, 315, -230, 330, -200, 355, -185, 385, 0, 0, 0};
        if (levelCounter >= 9) {
            vertices = new float[]{15, -400, 125, -380, 285, -300, 0, 0};
        }

        ChainShape chain = new ChainShape();
        chain.createLoop(vertices);
        FixtureDef chainFixture = new FixtureDef();
        chainFixture.shape = chain;
        chainFixture.density = 1;
        chainFixture.friction = 0;
        chainFixture.restitution = 0;
        body.createFixture(chainFixture);

        Fixture chainFix = body.createFixture(chainFixture);
        chainFix.setUserData("chainFixture");

        Fixture wheelFix = body.createFixture(fd);
        wheelFix.setUserData("wheelFixture");

        float wheelVelocity = new BigDecimal(customSpeed).floatValue();
        if (isClockwise) {
            body.applyAngularImpulse(-wheelVelocity, true);
        } else body.applyAngularImpulse(wheelVelocity, true);

        body.setUserData(wheelSprite);
    }

    private void createBall() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0, 5 / 2 - PHONE_HEIGHT / 2 + PHONE_HEIGHT / 2560 * 200);
        body2 = world.createBody(bodyDef);

        CircleShape circle = new CircleShape();
        circle.setRadius(3f);
        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 0;
        fd.friction = 0;
        fd.restitution = 0;
        body2.createFixture(fd);

        body2.setUserData(ballSprite);

        Fixture fdFixture = body2.createFixture(fd);
        fdFixture.setUserData("ballFixture");
    }

    private void createCollisionListener() {
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                if ((fixtureA.getUserData() == null) || (fixtureB.getUserData() == null)) {
                } else if (fixtureA.getUserData().equals("wheelFixture") && (fixtureB.getUserData().equals("ballFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                    levelCounter = 1;
                    game.setScreen(new GameScreen(game));
                } else if (fixtureB.getUserData().equals("wheelFixture") && (fixtureA.getUserData().equals("ballFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                    levelCounter = 1;
                    game.setScreen(new GameScreen(game));
                } else if (fixtureA.getUserData().equals("chainFixture") && (fixtureB.getUserData().equals("ballFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                    levelCounter++;
                    if (levelCounter == 25) {
                        game.setScreen(new WinScreen(game));
                    } else {
                        game.setScreen(new GameScreen(game));
                    }
                } else if (fixtureB.getUserData().equals("chainFixture") && (fixtureA.getUserData().equals("ballFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                    levelCounter++;
                    if (levelCounter == 25) {
                        game.setScreen(new WinScreen(game));
                    } else {
                        game.setScreen(new GameScreen(game));
                    }
                } else if (fixtureA.getUserData().equals("chainFixture") && (fixtureB.getUserData().equals("wheelFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                } else if (fixtureB.getUserData().equals("chainFixture") && (fixtureA.getUserData().equals("wheelFixture"))) {
                    fixtureA.setUserData(null);
                    fixtureB.setUserData(null);
                }
            }

            @Override
            public void endContact(Contact contact) {
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
                contact.setEnabled(false);
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        // prefs.flush();
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        textureBatch.dispose();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        final float BALL_VELOCITY = (new BigDecimal("11E+20").floatValue()) * PHONE_HEIGHT / 2560;
        body2.setLinearVelocity(0, BALL_VELOCITY);
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {
    }
}