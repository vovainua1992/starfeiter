package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.viev.GameScreen;

public class Background  extends GameObject{
    float speed = 100f;

    public Background(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
    }

    private void handle(){
        setPosition(bounds.getX(),bounds.getY()-speed* GameScreen.deltaCF);
        if(Gdx.input.isTouched())
            System.out.println(bounds.getY());
        if (bounds.getY()<-7110f)
            bounds.setPosition(bounds.getX(),7104);
    }

    @Override
    public void draw(SpriteBatch batch) {
        handle();
        super.draw(batch);
    }
}
