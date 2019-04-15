package com.space_feiter.control;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.space_feiter.control.Pool.AsteroidPool;
import com.space_feiter.model.Asteroid;

import java.util.Random;

public class AsteroidGreater {
    Random r = new Random();
    Texture textureAsteroids;
    public static Array<Asteroid> asteroids = new Array<Asteroid>();
    public static AsteroidPool pool;
    int i =0;
    private static int asteroidTime = 50;



    public AsteroidGreater(Texture texture,float[] verticesAsteroid){
        this.textureAsteroids = texture;
        pool = new AsteroidPool(30,180);
    }

    public void greateAsteroid(){
        float x;
        if(r.nextBoolean())
            x =(float) r.nextInt(10);
        else x = (float) -r.nextInt(10);

        asteroids.add(pool.obtain(x,15f));
    }



    public void drawALL(SpriteBatch batch ){
       for (int i = asteroids.size;i>0;i--){
           asteroids.get(i-1).draw(batch);
           }

    }

    public void dispose(){

    }



}
