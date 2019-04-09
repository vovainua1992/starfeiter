package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.control.ShipControl;

public class Corvet  extends Ship{
    private ShipControl control;
    public static float x;
    public static float y;



    public Corvet(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
        this.x = x;
        this.y = y;

        control = new ShipControl(bounds,this);

    }
    public Corvet(Texture texture, float[] polygon, float x, float y, float width,float heigth){
        super(texture,new Polygon(polygon),x,y,width,heigth);
        this.x = x;
        this.y = y;

        control = new ShipControl(bounds,this);
    }

    @Override
    public void draw(SpriteBatch batch) {
        this.x = getX();
        this.y =getY();
        super.draw(batch);
        control.handle();
    }


    public void dispose(){

    }

}
