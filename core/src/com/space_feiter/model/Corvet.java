package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.control.ShipControl;

public class Corvet  extends Ship{
    private ShipControl control;
    public static float x;
    public static float y;


    public Corvet(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
        this.x = x;
        this.y = y;
        control = new ShipControl(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        this.x = getX();
        this.y =getY();
        super.draw(batch);
        control.handle();
    }


}
