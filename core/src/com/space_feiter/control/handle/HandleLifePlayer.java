package com.space_feiter.control.handle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.GameObject;
import com.space_feiter.model.Life;
import com.space_feiter.viev.GameScreen;

import java.util.ArrayList;

public class HandleLifePlayer {
    private ArrayList<GameObject> lifes = new ArrayList<GameObject>();
    private int life;

    public HandleLifePlayer(int startLife,int maxLife, Texture shipTexture){
        life = startLife;
        float startPosX = -((Gdx.graphics.getWidth()*HandlerStatOfGame.zoom/2f)+1f);
        for (int i = 0;i<maxLife;i++){
            startPosX =startPosX+1f;
            float y = (Gdx.graphics.getHeight()*HandlerStatOfGame.zoom/2f)-1.7f;
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
