package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.space_feiter.control.Pool.BuletPool;
import com.space_feiter.control.handle.HandleLifePlayer;
import com.space_feiter.control.handle.HandleSound;
import com.space_feiter.model.Bulet;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.GameObject;
import com.space_feiter.model.StaticObject;
import com.space_feiter.util.MyJSonParseToPolygon;
import com.space_feiter.viev.GameScreen;

import java.util.ArrayList;

public class HandlerStatOfGame {
    static int lifePlayer;
    static Corvet corvetPlayer;
    static boolean corvetItsLife =true;
    public static int score = 0;
    private static boolean rightBulet = true;
    public float zoom = 1f;
    float tik = 0f;
    private GameScreen gameScreen;
    private AsteroidGreater asteroidGreater;
    private MessengeMeneger messengeMeneger;
    private static HandleLifePlayer handlerLife;
    private static Array<Bulet> bulets;

    private HandleSound handleSound = new HandleSound();

    Texture shipTexture;
    Texture boomTextore;
    public static Texture asteroidTexture;
    public static Texture buletTexture;
    private Texture gameOverTexture;
    private StaticObject gameOver;
    private static BuletPool buletPool ;
    public static boolean contolLeft,controlRicht,controlFire,controlNextSound,controlBackSound,controlLopingSound;



    float[] verticesShip;
    float[] verticesBom;
    float[] verticesAsteroid;

    public static float correlationShip;
    float correlationBom;
    float correlationAsteroid;
    public static float correlationBulet;
    private Array<Bulet> buletsOld;

    float timeNextAsteroid;
    float lastTimeAsteroid;
    float timeRestart=0f;
    float timeInv;
    private float timePresQ= 0f;

    //Game constant variable
    float widthShip = 1.5f;
    static float startAsteroidTime=1f;
    static float timeRestartShip = 0.5f;
    public static float invulnerabilityTime = 5f;
    public static float speedAsteroid=5f;
    public static float speedBulet=7f;
    public static float timeRebootWeapon = 0.3f;
    static float timeLivePermissionMesseng = 5f;
    private int startLife = 3;
    private int maxLife = 3;
    private static int numsBuletGreated;
    private float lockBottonTime = 0.5f;


    public void startGame(GameScreen gameScreen){
            this.gameScreen = gameScreen;
            lifePlayer = startLife;
            timeRestart = timeRestartShip;
            buletPool = new BuletPool(50,50);
            bulets = new Array<Bulet>();
            buletsOld = new Array<Bulet>();

            verticesShip = MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("test"));
            verticesBom =MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("bom"));
            verticesAsteroid=MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("asteroid"));

            shipTexture = new Texture(Gdx.files.internal("Ship.png"));
            shipTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationShip = (float)shipTexture.getWidth()/(float)shipTexture.getHeight();
            corvetPlayer = new Corvet(shipTexture,verticesShip,1f,-4f,widthShip,widthShip/correlationShip);
            corvetPlayer.setScale(widthShip,widthShip/correlationShip);

            gameOverTexture = new Texture(Gdx.files.internal("game_over.png"));
            gameOverTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            float cor = (float)gameOverTexture.getWidth()/(float)gameOverTexture.getHeight();
            gameOver = new StaticObject(gameOverTexture,-7f,-2f,10f,10f/cor);
            //gameOver.setScale(widthShip,widthShip/correlationShip);

            boomTextore = new Texture(Gdx.files.internal("bom.png"));
            boomTextore.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationBom = (float)boomTextore.getWidth()/(float)boomTextore.getHeight();

            buletTexture = new Texture(Gdx.files.internal("fire.png"));
            buletTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationBulet = (float)buletTexture.getWidth()/(float)buletTexture.getHeight();

            asteroidTexture = new Texture(Gdx.files.internal("asteroid.png"));
            asteroidTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
            correlationAsteroid = (float)asteroidTexture.getWidth()/(float)asteroidTexture.getHeight();

            asteroidGreater = new AsteroidGreater(asteroidTexture,verticesAsteroid);
            timeNextAsteroid = startAsteroidTime;
            lastTimeAsteroid = timeNextAsteroid;
            messengeMeneger = new MessengeMeneger();
            messengeMeneger.setPermissionMesenge("Hello",1f,Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);
            messengeMeneger.setStaticMess("score",Gdx.graphics.getWidth()-15*10f,Gdx.graphics.getHeight()-5f);
            handlerLife = new HandleLifePlayer(startLife,maxLife,shipTexture);
    }

    public static void addBulet(){
        if (rightBulet){
        bulets.add(buletPool.getBulet(corvetPlayer.getX()+1.05f,corvetPlayer.getY()+1.5f));
        rightBulet = false;}
        else {
        bulets.add(buletPool.getBulet(corvetPlayer.getX()+0.35f,corvetPlayer.getY()+1.5f));
        rightBulet = true;
        }

    }

    public static void reductionLife(){
        lifePlayer--;
        handlerLife.setLife(lifePlayer);
    }

    public void drawAll(SpriteBatch batch){
        corvetPlayer.draw(batch);
        asteroidGreater.drawALL(batch);
        handlerLife.draw(batch);
        drawBulet(batch);
    }

    private void drawBulet(SpriteBatch batch){
        for (int i = bulets.size;i>0;i--){
            bulets.get(i-1).draw(batch);
           // System.out.println(bulets.get(i-1).need);
            if(!bulets.get(i-1).need){
                buletPool.free(bulets.get(i-1));
                bulets.removeIndex(i-1);}
        }
       //  bulets.removeAll(buletsOld,true);
    }

    public void handleAll(float deltaTime, SpriteBatch batch){
        handleSound.handle();
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
                if(score%5==0){
                    System.out.println("Baf Speed");
                    speedAsteroid+=0.2f;
                }

                tik = 0f;
            }
        }else {
            if(lifePlayer>0){
            timeRestart =timeRestart - GameScreen.deltaCF;
            if(timeRestart<0){
            corvetPlayer.restarted();
            timeInv = invulnerabilityTime;
            corvetPlayer.invulnerability(timeInv);
            corvetItsLife = true;
            timeRestart = timeRestartShip;
            }
            }else {
                gameOver(batch);
                timeRestart-=GameScreen.deltaCF;
                if (timeRestart<0){
                corvetPlayer.setAlpha(0f);}
            }
        }
    }

    private void gameOver(SpriteBatch batch) {
        gameOver.draw(batch);
    }

    public void dispose() {
        shipTexture.dispose();
        boomTextore.dispose();
        asteroidTexture.dispose();
        asteroidGreater.dispose();
        messengeMeneger.dispose();
        gameOverTexture.dispose();
    }
}
