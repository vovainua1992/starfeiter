package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;



public abstract class GameObject {
 Polygon bounds;
 Sprite object;


 public GameObject(Texture texture,float x, float y, float width, float heigth){
    object = new Sprite(texture);
    object.setSize(width,heigth);
    object.setOrigin(width/2f,heigth/2f);



    bounds = new Polygon(new float[]{0f,0f,width,0f,width,heigth,0f,heigth});
    bounds.setPosition(x, y);
    bounds.setOrigin(width/2f,heigth/2f);
     System.out.println(x);
     System.out.println(bounds.getX());
 }

 public void draw(SpriteBatch batch){
     object.setPosition(bounds.getX(),bounds.getY());
     object.setRotation(bounds.getRotation());
     object.draw(batch);
 }

    public Polygon getBounds() {
        return bounds;
    }

    public float getX(){
        return bounds.getX();
    }

    public float getY(){
        return bounds.getY();
    }
}

