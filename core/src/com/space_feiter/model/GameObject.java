package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


public abstract class GameObject {
 Polygon bounds;
 Sprite object;

 public GameObject(Texture texture,Polygon polygon,float x, float y,float width,float heigth){
     object = new Sprite(texture);
     object.setSize(width,heigth);
     object.setOrigin(width/2f,heigth/2f);

     bounds = polygon;
     bounds.setPosition(x, y);
     bounds.setOrigin(width/2f,heigth/2f);
 }


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

 public boolean contact(Vector2 point){
     return bounds.contains(point);
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


