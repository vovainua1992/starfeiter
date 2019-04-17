package com.space_feiter.viev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.TimeUtils;

public class FrameRate implements Disposable {
    long lastTimeCounted;
    private float sinceChange;
    private static float frameRate;
    private BitmapFont font;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private float zoom = 0.7f;


    public FrameRate() {
        lastTimeCounted = TimeUtils.millis();
        sinceChange = 0;
        frameRate = Gdx.graphics.getFramesPerSecond();
        font = new BitmapFont();
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void resize(int screenWidth, int screenHeight) {
        cam = new OrthographicCamera(screenWidth, screenHeight);
        cam.zoom = zoom;

       cam.translate(screenWidth / 2f*zoom, screenHeight / 2f*zoom);
        cam.update();
        batch.setProjectionMatrix(cam.combined);

    }

    public void update() {
        long delta = TimeUtils.timeSinceMillis(lastTimeCounted);
        lastTimeCounted = TimeUtils.millis();

        sinceChange += delta;
        if(sinceChange >= 1000) {
            sinceChange = 0;
            frameRate = Gdx.graphics.getFramesPerSecond();
            //System.out.println(frameRate);
        }
    }

    public void render() {
       // System.out.println(frameRate);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //System.out.println(Gdx.graphics.getWidth());
        font.draw(batch, frameRate + " fps",10f*zoom, (Gdx.graphics.getHeight()-3f)*zoom);
        batch.end();
    }

    public void dispose() {
        font.dispose();
        batch.dispose();
    }
}
