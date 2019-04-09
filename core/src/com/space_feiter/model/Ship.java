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

    public void destroy(){
        float width = object.getWidth();
        float heigth = object.getHeight();
        float posX = bounds.getX();
        float posY = bounds.getY();
        object = new Sprite(new Texture(Gdx.files.internal("bom.png")));
        object.setSize(width,heigth);
        object.setOrigin(width/2f,heigth/2f);

        bounds = new Polygon(MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("bom")));
        bounds.setPosition(posX, posY);
        bounds.setOrigin(width/2f,heigth/2f);
    }







}
