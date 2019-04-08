package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.space_feiter.control.AsteroidControl;
import com.space_feiter.control.AsteroidGreater;

public class Asteroid extends GameObject{
    AsteroidControl AsteroidControl;
    private float distanceToShip;

    public Asteroid(Texture texture, Polygon polygon, float x, float y, float width, float heigth) {
        super(texture,polygon, x, y, width, heigth);
        AsteroidControl = new AsteroidControl(bounds);
    }


    @Override
    public void draw(SpriteBatch batch) {
        if (getY()>-15f) {
            super.draw(batch);
            AsteroidControl.handle();
        }
        else AsteroidGreater.asteroidsOld.add(this);

    }


}
