package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.util.MyJSonParseToPolygon;

public abstract class Ship extends GameObject {
    float alpha;

    public Ship(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
        alpha = object.getColor().a;
    }

    public Ship(Texture texture, Polygon polygon,float x,float y, float width,float heigth){
        super(texture,polygon,x,y,width,heigth);
        alpha = object.getColor().a;
    }

    public abstract void destroy();







}
