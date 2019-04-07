package com.space_feiter.viev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.space_feiter.control.AsteroidGreater;
import com.space_feiter.model.Asteroid;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.GameObject;
import com.space_feiter.model.Mesenges;


public class GameScreen implements Screen {
    private Texture texture;
    private Texture textureAsteroid;
    private SpriteBatch batch;
    private Corvet corvet;
    private Asteroid asteroid;
    private OrthographicCamera camera ;
    Mesenges mm;
    public static float deltaCF;
    AsteroidGreater asteroidGreater;


    private FrameRate frameRate;

    private GameObject[] actors = new GameObject[2];


    @Override
    public void show() {
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Ship.png"));
        textureAsteroid = new Texture(Gdx.files.internal("asteroid.psd"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        corvet = new Corvet(texture,0,-5,4f,4f);
        asteroid = new Asteroid(textureAsteroid,0,+5,1f,1f);
        asteroidGreater = new AsteroidGreater();
        frameRate = new FrameRate();
        mm = new Mesenges();
        String str = "Score - ";
        mm.setStaticMess("score",Gdx.graphics.getWidth()-15*str.length(),Gdx.graphics.getHeight()-5f);
        mm.setPermissionMesenge("Game Start",500,Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        asteroidGreater.greateAsteroid();

        deltaCF = delta;
        mm.render();
        batch.setProjectionMatrix(camera.combined);
        frameRate.update();
        frameRate.render();

        batch.begin();
        asteroidGreater.drawALL(batch);
        asteroid.draw(batch);
        corvet.draw(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera = new OrthographicCamera(20f,20f*aspectRatio);
        camera.zoom = 0.9f;
        camera.position.set(new Vector3(2f,2f,10f));
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
        texture.dispose();
        batch.dispose();
        mm.dispose();
        frameRate.dispose();
    }
}
