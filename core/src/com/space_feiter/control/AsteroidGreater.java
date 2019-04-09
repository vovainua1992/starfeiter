package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.model.Asteroid;
import com.space_feiter.util.MyJSonParseToPolygon;

import java.util.ArrayList;
import java.util.Random;

public class AsteroidGreater {
    Random r = new Random();
    Texture textureAsteroids;
    public static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    public static ArrayList<Asteroid> asteroidsOld = new ArrayList<Asteroid>();
    int i =0;
    private static int asteroidTime = 50;
    private float[] verticesAsteroid;


    public AsteroidGreater(Texture texture,float[] verticesAsteroid){
        this.textureAsteroids = texture;
        this.verticesAsteroid = verticesAsteroid;
    }

    public void greateAsteroid(){
        float x;
        if(r.nextBoolean())
            x =(float) r.nextInt(10);
        else x = (float) -r.nextInt(10);

        asteroids.add(new Asteroid(textureAsteroids,verticesAsteroid,x,15f,1f,1f));
    }



    public void drawALL(SpriteBatch batch ){
       for (int i = asteroids.size();i>0;i--){
           asteroids.get(i-1).draw(batch);
           }
       asteroids.removeAll(asteroidsOld);
    }

    public void dispose(){

    }



}
