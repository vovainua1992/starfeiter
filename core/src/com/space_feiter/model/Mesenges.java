package com.space_feiter.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.space_feiter.control.HandlePermissionMessenge;
import com.space_feiter.control.HandleScoreMessenge;

import java.util.ArrayList;
import java.util.Collections;

public class Mesenges implements Disposable {
    BitmapFont font;
    SpriteBatch batch;
    OrthographicCamera cam;
    static ArrayList<Mess> messes = new ArrayList<Mess>();
    ArrayList<Mess> deleteList = new ArrayList<Mess>();



    public Mesenges(){
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    public  static void setPermissionMesenge(String mesenge,int numsFrameLive,float posX,float posY){
        messes.add(new Mess(mesenge,numsFrameLive,new HandlePermissionMessenge(),posX,posY));

    }

    public static void setStaticMess(String mess,float x,float y){
        messes.add(new Mess(mess,new HandleScoreMessenge(mess),x,y));
    }

    private void renderAll(){
        for(int i=messes.size();i>0;i--){
           font.draw(batch,messes.get(i-1).mess,messes.get(i-1).x,messes.get(i-1).y);
            messes.get(i-1).handle();
            if (!messes.get(i-1).need){
                deleteList.add(messes.get(i-1));
            }
        }
        messes.removeAll(deleteList);
    }

    public void render(){
        batch.begin();
        renderAll();
        batch.end();
    }

    public void dispose(){
        font.dispose();
        batch.dispose();
    }

    public void reize(){

    }
}
