package com.space_feiter.control.Pool;

import com.badlogic.gdx.utils.Pool;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Bulet;

public class BuletPool extends Pool<Bulet> {
    @Override
    protected Bulet newObject() {
        return new Bulet(HandlerStatOfGame.buletTexture,0f,0f,0.1f,0.1f);
    }

    public Bulet getBulet(float posX,float posY){
        Bulet b = obtain();
        b.reFire(posX, posY);
        return b;

    }
}
