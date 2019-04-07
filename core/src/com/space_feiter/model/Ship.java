package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Ship extends GameObject {
    float hp ;
    float speed;
    float speedRotate;
    float damage;




    public Ship(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
    }





}
