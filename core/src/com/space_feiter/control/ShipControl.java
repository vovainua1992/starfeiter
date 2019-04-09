package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.model.Corvet;
import com.space_feiter.viev.GameScreen;
import com.badlogic.gdx.math.Intersector;

public class ShipControl {
    private Polygon shipBounds;
    private float speed = 0f,minX =-(float) Gdx.graphics.getBackBufferWidth()/150,maxX = (float) Gdx.graphics.getBackBufferWidth()/150;
    MessengeMeneger messengeMeneger = new MessengeMeneger();
    Corvet corvet;
    private boolean needed = true;
       Vector2[] pointsVertices=new Vector2[5];


    public ShipControl(Polygon shipBounds, Corvet corvet){
        this.shipBounds = shipBounds;
        this.corvet = corvet;
          }

    public void handle(){
        if (needed){
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                speed-=0.1f;
            }else
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                speed+=0.1f;
            }else
                dowmSpeed();
            if (contactToAsteroid()){
                System.out.println("Asteroid conect to ship");
                corvet.destroy();
                needed = false;

            }
            shipBounds.setPosition(LimitedX(shipBounds.getX()+speed*GameScreen.deltaCF),shipBounds.getY());
        }
    }


    private boolean contactToAsteroid(){

        for (int i = AsteroidGreater.asteroids.size();i>0;i--){
            if (Intersector.overlapConvexPolygons(shipBounds,AsteroidGreater.asteroids.get(i-1).getBounds())){
           return true;}

        }
        return false;
    }

    private void dowmSpeed() {
        if (speed>0.1f){
            speed-=0.5f;
        }else
        if (speed<-0.1f){
            speed+=0.5f;
        }else speed=0;
    }

    float LimitedX (float newX) {
        if (newX < minX)
        {
            speed = 0f;
            return minX;
        }

        if (newX>maxX){
            speed = 0f;
            return maxX;
        }
        return newX;
    }

}
