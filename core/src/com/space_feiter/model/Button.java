package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;

public class Button extends GameObject{
    public boolean isPressed;
    public int numToch=-1;

    public Button(Texture texture,  float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
      //  bounds.setScale(width,width);
    }
}
