package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.util.MyJSonParseToPolygon;


public abstract class GameObject {
 Polygon bounds;
 Sprite object;



 public GameObject(Texture texture,Polygon polygon,float x, float y,float width,float heigth){
     object = new Sprite(texture);
     object.setSize(width,heigth);
     object.setOrigin(width/2f,heigth/2f);

     bounds = new Polygon(polygon.getVertices());
     bounds.setOrigin(polygon.getOriginX(),polygon.getOriginY());
     bounds.setScale(2f,1.5f);
     bounds.setPosition(x, y);
 }


 public GameObject(Texture texture,float x, float y, float width, float heigth){
    object = new Sprite(texture);
    object.setSize(width,heigth);
    object.setOrigin(width/2f,heigth/2f);
    bounds = new Polygon(new float[]{0f,0f,width,0f,width,heigth,0f,heigth});
    bounds.setPosition(x, y);
    bounds.setOrigin(width/2f,heigth/2f);
 }


 public void draw(SpriteBatch batch){
     object.setPosition(bounds.getX(),bounds.getY());
     object.setRotation(bounds.getRotation());
     object.draw(batch);
 }

    public void setScale(float x,float y){
     bounds.setScale(x,y);
    }

    public void setPosition(float x,float y){
        bounds.setPosition(x,y);
    }

    public float[] getVertices(){
         return bounds.getTransformedVertices();
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

    public float getSceleWidth(){
        return object.getWidth();
    }
}


