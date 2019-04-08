package com.space_feiter.viev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.space_feiter.control.AsteroidGreater;
import com.space_feiter.model.Asteroid;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.GameObject;
import com.space_feiter.model.Mesenges;
import com.space_feiter.util.MyJSonParseToPolygon;


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
    MyJSonParseToPolygon parseToPolygon;
    private FrameRate frameRate;

    private GameObject[] actors = new GameObject[2];


    @Override
    public void show() {
        parseToPolygon = new MyJSonParseToPolygon();
        parseToPolygon.parseJson("{\"rigidBodies\":[{\"name\":\"Ship.png\",\"imagePath\":\"../Progect libgdx/Space feiter/android/assets/Ship.png\",\"origin\":{\"x\":0,\"y\":0},\"polygons\":[[{\"x\":0.8333334922790527,\"y\":0.9583334922790527},{\"x\":0.8295456171035767,\"y\":1.075757622718811},{\"x\":0.75,\"y\":1.147727370262146},{\"x\":0.7272727489471436,\"y\":1.01893949508667}],[{\"x\":0.7272727489471436,\"y\":1.01893949508667},{\"x\":0.6325758099555969,\"y\":1.0833333730697632},{\"x\":0.8901516199111938,\"y\":0.5416666865348816},{\"x\":0.9053032398223877,\"y\":0.8939394950866699}],[{\"x\":0.9053032398223877,\"y\":0.8939394950866699},{\"x\":0.8333334922790527,\"y\":0.9583334922790527},{\"x\":0.7272727489471436,\"y\":1.01893949508667}],[{\"x\":0.6325758099555969,\"y\":1.0833333730697632},{\"x\":0.5075758099555969,\"y\":1.3636363744735718},{\"x\":0.36500000953674316,\"y\":1.0875000953674316}],[{\"x\":0.2524999678134918,\"y\":1.037500023841858},{\"x\":0.26499998569488525,\"y\":1.1425000429153442},{\"x\":0.16249999403953552,\"y\":1.0824999809265137},{\"x\":0.16249999403953552,\"y\":0.9550000429153442}],[{\"x\":0.07999995350837708,\"y\":0.17499998211860657},{\"x\":0.13249996304512024,\"y\":0.06999993324279785},{\"x\":0.8712123036384583,\"y\":0.053030259907245636},{\"x\":0.9545455574989319,\"y\":0.1931818425655365},{\"x\":0.946969747543335,\"y\":0.39393940567970276}],[{\"x\":0.946969747543335,\"y\":0.39393940567970276},{\"x\":0.8901516199111938,\"y\":0.5416666865348816},{\"x\":0.6325758099555969,\"y\":1.0833333730697632},{\"x\":0.36500000953674316,\"y\":1.0875000953674316},{\"x\":0.2524999678134918,\"y\":1.037500023841858},{\"x\":0.07999995350837708,\"y\":0.17499998211860657}],[{\"x\":0.2524999678134918,\"y\":1.037500023841858},{\"x\":0.09499996900558472,\"y\":0.5800000429153442},{\"x\":0.04999995231628418,\"y\":0.4399999976158142},{\"x\":0.024999946355819702,\"y\":0.304999977350235},{\"x\":0.04249998927116394,\"y\":0.16499999165534973},{\"x\":0.07999995350837708,\"y\":0.17499998211860657}],[{\"x\":0.2524999678134918,\"y\":1.037500023841858},{\"x\":0.16249999403953552,\"y\":0.9550000429153442},{\"x\":0.10499998927116394,\"y\":0.8825000524520874},{\"x\":0.09499996900558472,\"y\":0.5800000429153442}]],\"circles\":[],\"shapes\":[{\"type\":\"POLYGON\",\"vertices\":[{\"x\":0.13249996304512024,\"y\":0.06999993324279785},{\"x\":0.07999995350837708,\"y\":0.17499998211860657},{\"x\":0.04249998927116394,\"y\":0.16499999165534973},{\"x\":0.024999946355819702,\"y\":0.304999977350235},{\"x\":0.04999995231628418,\"y\":0.4399999976158142},{\"x\":0.09499996900558472,\"y\":0.5800000429153442},{\"x\":0.10499998927116394,\"y\":0.8825000524520874},{\"x\":0.16249999403953552,\"y\":0.9550000429153442},{\"x\":0.16249999403953552,\"y\":1.0824999809265137},{\"x\":0.26499998569488525,\"y\":1.1425000429153442},{\"x\":0.2524999678134918,\"y\":1.037500023841858},{\"x\":0.36500000953674316,\"y\":1.0875000953674316},{\"x\":0.5075758099555969,\"y\":1.3636363744735718},{\"x\":0.6325758099555969,\"y\":1.0833333730697632},{\"x\":0.7272727489471436,\"y\":1.01893949508667},{\"x\":0.75,\"y\":1.147727370262146},{\"x\":0.8295456171035767,\"y\":1.075757622718811},{\"x\":0.8333334922790527,\"y\":0.9583334922790527},{\"x\":0.9053032398223877,\"y\":0.8939394950866699},{\"x\":0.8901516199111938,\"y\":0.5416666865348816},{\"x\":0.946969747543335,\"y\":0.39393940567970276},{\"x\":0.9545455574989319,\"y\":0.1931818425655365},{\"x\":0.8712123036384583,\"y\":0.053030259907245636}]}]}],\"dynamicObjects\":[]}");


        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("Ship.png"));
        textureAsteroid = new Texture(Gdx.files.internal("asteroid.psd"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        corvet = new Corvet(texture,parseToPolygon.getPolygon(),0,-4,2f,2f);
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
