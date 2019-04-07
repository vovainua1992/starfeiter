package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.model.Mesenges;
import com.space_feiter.util.Debug;
import com.space_feiter.viev.GameScreen;

public class ShipControl {
    private Polygon shipBounds;
    private float speed = 1f,minX =-Gdx.graphics.getWidth()/150,maxX = Gdx.graphics.getWidth()/150;
    Mesenges mesenges = new Mesenges();

    public ShipControl(Polygon shipBounds){
    this.shipBounds = shipBounds;
    }

    public void handle(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            speed-=0.1f;
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            speed+=0.1f;
        }else
            dowmSpeed();


        shipBounds.setPosition(LimitedX(shipBounds.getX()+speed*GameScreen.deltaCF),shipBounds.getY());
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
