package com.space_feiter.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;

public class StaticObject extends GameObject {
    public StaticObject(Texture texture, Polygon polygon, float x, float y, float width, float heigth) {
        super(texture, polygon, x, y, width, heigth);
    }
    public StaticObject(Texture texture, float x, float y, float width, float heigth) {
        super(texture, x, y, width, heigth);
    }
}
