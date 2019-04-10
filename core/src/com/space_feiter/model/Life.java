package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;

public class Life extends GameObject {


    public Life(Texture texture,  float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
        object.setAlpha(0.7f);
    }
}
