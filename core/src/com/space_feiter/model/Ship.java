package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public abstract class Ship extends GameObject {
    float hp ;
    float speed;
    float speedRotate;
    float damage;




    public Ship(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
    }

    public Ship(Texture texture, Polygon polygon,float x,float y, float width,float heigth){
        super(texture,polygon,x,y,width,heigth);
    }





}
