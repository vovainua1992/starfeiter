package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.model.Corvet;
import com.space_feiter.util.MyJSonParseToPolygon;
import com.space_feiter.viev.GameScreen;

public class HandlerStatOfGame {
    static int lifePlayer = 3;
    static Corvet corvetPlayer;
    static boolean corvetItsLife =true;
    public static int score = 0;
    public float zoom = 1f;
    float tik = 0f;
    private GameScreen gameScreen;
    private AsteroidGreater asteroidGreater;
    private MessengeMeneger messengeMeneger;

    Texture shipTexture;
    Texture boomTextore;
    Texture asteroidTexture;



    float[] verticesShip;
    float[] verticesBom;
    float[] verticesAsteroid;

    float correlationShip;
    float correlationBom;
    float correlationAsteroid;

    float timeNextAsteroid;
    float lastTimeAsteroid;

    //Game constant variable
    float widthShip = 1.5f;
    static float startAsteroidTime=5f;
    static float timeRestartShip = 3f;
    static float invulnerabilityTime = 5f;
    static float timeLivePermissionMesseng = 5f;


    public void startGame(GameScreen gameScreen){
            this.gameScreen = gameScreen;

            verticesShip = MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("test"));
            verticesBom =MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("bom"));
            verticesAsteroid=MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("asteroid"));

            shipTexture = new Texture(Gdx.files.internal("Ship.png"));
            shipTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationShip = (float)shipTexture.getWidth()/(float)shipTexture.getHeight();
            corvetPlayer = new Corvet(shipTexture,verticesShip,1f,-4f,widthShip,widthShip/correlationShip);
            corvetPlayer.setScale(widthShip,widthShip/correlationShip);

            boomTextore = new Texture(Gdx.files.internal("bom.png"));
            boomTextore.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationBom = (float)boomTextore.getWidth()/(float)boomTextore.getHeight();

            asteroidTexture = new Texture(Gdx.files.internal("asteroid.png"));
            asteroidTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationAsteroid = (float)asteroidTexture.getWidth()/(float)asteroidTexture.getHeight();

            asteroidGreater = new AsteroidGreater(asteroidTexture,verticesAsteroid);
            timeNextAsteroid = startAsteroidTime;
            lastTimeAsteroid = timeNextAsteroid;
            messengeMeneger = new MessengeMeneger();
            messengeMeneger.setPermissionMesenge("Hello",1f,Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);
            messengeMeneger.setStaticMess("score",Gdx.graphics.getWidth()-15*10f,Gdx.graphics.getHeight()-5f);
    }

    private void drawLivePlayer(){

    }

    public void drawAll(SpriteBatch batch){

        corvetPlayer.draw(batch);
        asteroidGreater.drawALL(batch);
    }

    public void handleAll(float deltaTime, SpriteBatch batch){
        timeNextAsteroid=timeNextAsteroid-deltaTime;
        if (timeNextAsteroid<0){
        asteroidGreater.greateAsteroid();
        timeNextAsteroid = lastTimeAsteroid;
        lastTimeAsteroid = lastTimeAsteroid -0.01f;
        if (!(lastTimeAsteroid>0)){
            lastTimeAsteroid =0.2f;
        }
        }
        if(corvetItsLife){
            tik+=deltaTime;

            if (tik>1f){
                score++;
                tik = 0f;
            }
        }else {

        }
    }

    public void dispose() {
        shipTexture.dispose();
        boomTextore.dispose();
        asteroidTexture.dispose();
        asteroidGreater.dispose();
        messengeMeneger.dispose();
    }
}
