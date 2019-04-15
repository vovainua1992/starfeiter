package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.control.handle.HandleSound;
import com.space_feiter.model.Corvet;
import com.space_feiter.viev.GameScreen;
import com.badlogic.gdx.math.Intersector;

public class ShipControl {
    private Polygon shipBounds;
    private float speed = 0f,minX =-10f,maxX = 8.5f;
    Corvet corvet;
    private boolean needed = true;
    private boolean vulnerability = true;
    private float rebootWeaponTime;
   int numContact;


    public ShipControl(Polygon shipBounds, Corvet corvet){
        this.shipBounds = shipBounds;
        this.corvet = corvet;
        rebootWeaponTime = 0f;
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
            if (vulnerability){
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
                if (!(rebootWeaponTime>0)){
                    shot();
                }

            if (contactToAsteroid()){
            //    System.out.println("Asteroid conect to ship");
                HandlerStatOfGame.reductionLife();
                HandlerStatOfGame.corvetItsLife = false;
                corvet.destroy();
                needed = false;

            }
            }else corvet.invulnerability(corvet.timeInv);{

            }
            rebootWeaponTime-=GameScreen.deltaCF;
            shipBounds.setPosition(LimitedX(shipBounds.getX()+speed*GameScreen.deltaCF),shipBounds.getY());
        }
    }

    public void setVulnerability (boolean b){
        vulnerability = b;
    }

    public void setNewShip(boolean b,Polygon shipBounds){
        this.shipBounds = shipBounds;
        needed = b;
    }

    private boolean contactToAsteroid(){
        for (int i = AsteroidGreater.asteroids.size;i>0;i--){
            if (Intersector.overlapConvexPolygons(shipBounds,AsteroidGreater.asteroids.get(i-1).getBounds())){
            numContact = i-1;
           return true;}

        }
        return false;
    }

    private void shot(){
        HandleSound.piu.play(0.3f);
        HandlerStatOfGame.addBulet();
        rebootWeaponTime = HandlerStatOfGame.timeRebootWeapon;
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
