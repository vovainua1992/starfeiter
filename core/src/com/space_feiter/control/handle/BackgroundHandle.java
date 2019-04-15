package com.space_feiter.control.handle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.model.Background;

public class BackgroundHandle {
    private Background one;
    private Background two;
    private OrthographicCamera camBackGround;
    private SpriteBatch batch;
    private Texture texture;

    public BackgroundHandle(){
        texture = new Texture(Gdx.files.internal("background.png"));
        camBackGround = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


    }

    public void draw(){

    }

    public void resize(){}


    public void dispose(){
        batch.dispose();
        texture.dispose();
    }
}
