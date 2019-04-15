package com.space_feiter.control.handle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.GameObject;
import com.space_feiter.model.Life;

import java.util.ArrayList;

public class HandleLifePlayer {
    private ArrayList<GameObject> lifes = new ArrayList<GameObject>();
    private int life;

    public HandleLifePlayer(int startLife,int maxLife, Texture shipTexture){
        life = startLife;
        float startPosX = -13f;
        for (int i = 0;i<maxLife;i++){
            startPosX =startPosX+1f;
            //System.out.println(Gdx.graphics.getHeight());
            float y = (float) 3f;
            //System.out.println(y);
            Life life = new Life(shipTexture,startPosX, y,1f,1f/ HandlerStatOfGame.correlationShip);
            lifes.add(life);

        }

    }

    public void setLife(int newLife){
        life = newLife;
    }

    public void draw(SpriteBatch batch){
        for (int i =0;i<life;i++){
            lifes.get(i).draw(batch);
        }
    }
}
