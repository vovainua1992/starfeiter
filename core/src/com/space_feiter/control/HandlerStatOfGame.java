package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private static ArrayList<Bulet> bulets = new ArrayList<Bulet>();
    private static ArrayList<Bulet> freeBulets = new ArrayList<Bulet>();
    private HandleSound handleSound = new HandleSound();

    Texture shipTexture;
    Texture boomTextore;
    Texture asteroidTexture;
    public static Texture buletTexture;
    private Texture gameOverTexture;
    private StaticObject gameOver;



    float[] verticesShip;
    float[] verticesBom;
    float[] verticesAsteroid;

    public static float correlationShip;
    float correlationBom;
    float correlationAsteroid;
    private static float correlationBulet;


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
        if(freeBulets.size()>0){
            if (rightBulet){
                freeBulets.get(0).reFire( corvetPlayer.getX()+1.1f,corvetPlayer.getY()+1.5f);
                bulets.add(freeBulets.get(0));
                freeBulets.remove(0);
                rightBulet = false;}
            else {
                freeBulets.get(0).reFire( corvetPlayer.getX()+0.3f,corvetPlayer.getY()+1.5f);
                bulets.add(freeBulets.get(0));
                freeBulets.remove(0);
                rightBulet = true;
            }
        }else {
            numsBuletGreated++;
        if (rightBulet){
        bulets.add(new Bulet(buletTexture, corvetPlayer.getX()-0.9f,corvetPlayer.getY()-0.5f,0.1f,0.1f/correlationBulet));
        rightBulet = false;}
        else {
        bulets.add(new Bulet(buletTexture, corvetPlayer.getX()-1.7f,corvetPlayer.getY()-0.5f,0.1f,0.1f/correlationBulet));
        rightBulet = true;
        }
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
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            speedBulet = 10f;
        }
        timePresQ-=GameScreen.deltaCF;
        if (timePresQ<0){
        if (Gdx.input.isKeyPressed(Input.Keys.Q)){
            handleSound.nextTrack();
            timePresQ = lockBottonTime;
        }}
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            speedBulet = 0.1f;
        }
        for (int i = bulets.size();i>0;i--){
            bulets.get(i-1).draw(batch);
            if(!bulets.get(i-1).need){
                freeBulets.add(bulets.get(i-1));
                bulets.remove(i-1);
            }
        }
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
