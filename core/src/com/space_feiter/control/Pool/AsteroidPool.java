package com.space_feiter.control.Pool;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Pool;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Asteroid;

public class AsteroidPool extends Pool<Asteroid> {
    public AsteroidPool(int i, int i1) {
        super(i ,i1);
    }

    @Override
    protected Asteroid newObject() {
        return new Asteroid(HandlerStatOfGame.asteroidTexture,0f,0f,1f,1f);
    }

    public Asteroid obtain(float x, float y) {
       Asteroid a =  obtain();
       a.setPosition(x, y);
       return a;
    }
}
