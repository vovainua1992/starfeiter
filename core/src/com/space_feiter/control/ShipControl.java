package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.model.Mesenges;
import com.space_feiter.util.Debug;
import com.space_feiter.viev.GameScreen;

public class ShipControl {
    private Polygon shipBounds;
    private float speed = 1f,minX =-Gdx.graphics.getWidth()/150,maxX = Gdx.graphics.getWidth()/150;
    Mesenges mesenges = new Mesenges();
    float[] vertices;
    Vector2[] pointsVertices=new Vector2[5];


    public ShipControl(Polygon shipBounds){

        this.shipBounds = shipBounds;
        vertices = shipBounds.getTransformedVertices();

    }

    public void handle(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            speed-=0.1f;
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            speed+=0.1f;
        }else
            dowmSpeed();
        if (contactToAsteroid()){
            System.out.println("Asteroid conect to ship");
        }
        shipBounds.setPosition(LimitedX(shipBounds.getX()+speed*GameScreen.deltaCF),shipBounds.getY());
    }


    private boolean contactToAsteroid(){
        pointsVertices[0] = new Vector2(vertices[0],vertices[1]);
        pointsVertices[1] = new Vector2(vertices[2],vertices[3]);
        pointsVertices[2] = new Vector2(vertices[4],vertices[5]);
        pointsVertices[3] = new Vector2(vertices[6],vertices[7]);
        pointsVertices[4] = new Vector2(shipBounds.getX(),shipBounds.getY());
        boolean res = false;
        for (int i = AsteroidGreater.asteroids.size();i>0;i--){
            if ( AsteroidGreater.asteroids.get(i-1).contact(pointsVertices[0])){
                AsteroidGreater.asteroidsOld.add(AsteroidGreater.asteroids.get(i-1));
                return true;
            }else
                if ( AsteroidGreater.asteroids.get(i-1).contact(pointsVertices[1])){
                    AsteroidGreater.asteroidsOld.add(AsteroidGreater.asteroids.get(i-1));
                    return true;
                }else
                     if ( AsteroidGreater.asteroids.get(i-1).contact(pointsVertices[2])){
                         AsteroidGreater.asteroidsOld.add(AsteroidGreater.asteroids.get(i-1));
                        return true;
                    }else
                        if ( AsteroidGreater.asteroids.get(i-1).contact(pointsVertices[3])){
                            AsteroidGreater.asteroidsOld.add(AsteroidGreater.asteroids.get(i-1));
                            return true;
                        }else
                        if ( AsteroidGreater.asteroids.get(i-1).contact(pointsVertices[4])){
                            AsteroidGreater.asteroidsOld.add(AsteroidGreater.asteroids.get(i-1));
                            return true;
                        }

        }


        return res;

    }

    private void dowmSpeed() {
        if (speed>0.1f){
            speed-=0.1f;
        }else
        if (speed<-0.1f){
            speed+=0.1f;
        }else speed=0;
    }

    float LimitedX (float newX){
        if (newX<minX)
            return minX;
        if (newX>maxX)
            return maxX;
        return newX;
    }

}
