package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.control.ShipControl;
import com.space_feiter.util.MyJSonParseToPolygon;
import com.space_feiter.viev.GameScreen;

public class Corvet  extends Ship{
    private ShipControl control;
    public static float x;
    public static float y;
    private float alpha;
    public float timeInv;
    private boolean alphaUp = false;

    public Corvet(Texture texture, float[] polygon, float x, float y, float width,float heigth){
        super(texture,new Polygon(polygon),x-1.5f,y-2f,width,heigth);
        this.x = x;
        this.y = y;
        alpha =  object.getColor().a;
        control = new ShipControl(bounds,this);
    }

    @Override
    public void destroy() {
        float width = object.getWidth();
        float heigth = object.getHeight();
        float posX = bounds.getX();
        float posY = bounds.getY();
        object = new Sprite(new Texture(Gdx.files.internal("bom.png")));
        object.setSize(width,heigth);
        object.setOrigin(width/2f,heigth/2f);

        bounds = new Polygon(MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("bom")));
        bounds.setPosition(posX, posY);
        bounds.setScale(1.5f,2f);
        //bounds.setOrigin(width/2f,heigth/2f);
    }
    @Override
    public void draw(SpriteBatch batch) {
        this.x = getX();
        this.y =getY();
        super.draw(batch);
        control.handle();
    }

    public void invulnerability(float time){
        timeInv = time;
        timeInv = timeInv- GameScreen.deltaCF;
        if (time<0){
            control.setVulnerability(true);
            alpha = 1f;
        }else {
           if (alphaUp){
               if (alpha<1)
               alpha+=0.04f;
               else alphaUp = false;
           }else
               if (alpha>0.4)
                alpha-=0.04f;
               else  alphaUp = true;

        }
        object.setAlpha(alpha);
    }

    public void restarted() {
        float width = object.getWidth();
        float heigth = object.getHeight();
        float posY = bounds.getY();
        object = new Sprite(new Texture(Gdx.files.internal("Ship.png")));
        object.setSize(width,heigth);
        object.setOrigin(width/2f,heigth/2f);

        bounds = new Polygon(MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("test")));
        bounds.setPosition(-0.5f, posY);
        bounds.setScale(width,width);
        control.setNewShip(true,bounds);
        control.setVulnerability(false);
    }

    public void setAlpha(float v) {
        object.setAlpha(v);
    }
}
