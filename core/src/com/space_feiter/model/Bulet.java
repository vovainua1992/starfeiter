package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.control.AsteroidGreater;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.control.handle.HandleSound;
import com.space_feiter.viev.GameScreen;

public class Bulet extends GameObject {
    private float maxY =6.7f;
    private float speed;
    public boolean need = true;
    private int numContact=-1;

    public Bulet(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
    }

    public void reFire( float x, float y){
        bounds.setPosition(x,y);
        need = true;
    }

    private void move(){
        speed=HandlerStatOfGame.speedBulet* GameScreen.deltaCF;
        if ((speed+bounds.getY())>maxY){
            speed = 0f;
            need = false;
        }
        bounds.setPosition(bounds.getX(),bounds.getY()+ speed);
    }

    private void itsContactEnemy(){
        for (int i=AsteroidGreater.asteroids.size;i>0;i--){
          if(Intersector.overlapConvexPolygons(AsteroidGreater.asteroids.get(i-1).bounds,bounds)){
              AsteroidGreater.pool.free(AsteroidGreater.asteroids.get(i-1));
              numContact = i-1;
                need = false;
                HandlerStatOfGame.score+=100;
                HandleSound.boom.play(0.3f);
            }
        }
        if (numContact!=-1){
        AsteroidGreater.asteroids.removeIndex(numContact);
        numContact=-1;}
    }

    private void handle(){
        move();
        itsContactEnemy();
    }

    @Override
    public void draw(SpriteBatch batch) {
        handle();
        super.draw(batch);
    }
}
