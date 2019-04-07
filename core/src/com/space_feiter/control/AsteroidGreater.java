package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.model.Asteroid;

import java.util.ArrayList;
import java.util.Random;

public class AsteroidGreater {
    Random r = new Random();
    Texture texture;
    public static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    public static ArrayList<Asteroid> asteroidsOld = new ArrayList<Asteroid>();
    int i =0;
    private static int asteroidTime = 200;


    public AsteroidGreater(){
        texture = new Texture(Gdx.files.internal("asteroid.psd"));

    }

    public void greateAsteroid(){

        i++;
        if (i >asteroidTime){
        float x;
        if(r.nextBoolean())
            x =(float) r.nextInt(10);
        else x = (float) -r.nextInt(10);
        asteroids.add(new Asteroid(texture,x,15f,1f,1f));
           i =0;
     }
    }



    public void drawALL(SpriteBatch batch){
       for (int i = asteroids.size();i>0;i--){
           asteroids.get(i-1).draw(batch);
           }
       asteroids.removeAll(asteroidsOld);
    }



}
