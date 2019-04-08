package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.viev.GameScreen;


public class AsteroidControl {
    private Polygon boundAsteroid;
    private float speed = 5f, minY = -Gdx.graphics.getHeight() / 100;

    public AsteroidControl(Polygon boundAsteroid) {
        this.boundAsteroid = boundAsteroid;
    }

    public void handle() {
        boundAsteroid.setPosition(boundAsteroid.getX(),
                boundAsteroid.getY() - speed * GameScreen.deltaCF);
    }

}