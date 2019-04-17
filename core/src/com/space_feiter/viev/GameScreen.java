package com.space_feiter.viev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.control.MessengeMeneger;
import com.space_feiter.control.handle.BackgroundHandle;


public class GameScreen implements Screen {
    private SpriteBatch batch;
    public static OrthographicCamera camera ;

    public static float deltaCF;
    private FrameRate frameRate;
    HandlerStatOfGame handlerStats;
    BackgroundHandle backgroundHandle;



    @Override
    public void show() {
        handlerStats = new HandlerStatOfGame();
        handlerStats.startGame();
        batch = new SpriteBatch();
        frameRate = new FrameRate();
        backgroundHandle =new BackgroundHandle();
        Gdx.input.setInputProcessor(HandlerStatOfGame.controllPlayer.inputProcessor);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCF = delta;
        batch.setProjectionMatrix(camera.combined);

        frameRate.update();
        frameRate.render();

        backgroundHandle.draw();
        MessengeMeneger.render();

        handlerStats.drawAll(batch);
        handlerStats.handleAll(delta,batch);
    }

    @Override
    public void resize(int width, int height) {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.zoom = handlerStats.zoom;
        frameRate.resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(new Vector3(0f,0f,10f));
        camera.update();
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
        frameRate.dispose();
        handlerStats.dispose();
    }
}
