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
        batch=new SpriteBatch();
        camBackGround.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        camBackGround.update();
        batch.setProjectionMatrix(camBackGround.combined);

        one = new Background(texture,0,-Gdx.graphics.getHeight()/2f,Gdx.graphics.getWidth(),Gdx.graphics.getWidth()*4);
        System.out.println(Gdx.graphics.getWidth()*4f);

    }

    public void draw(){
        batch.begin();
        one.draw(batch);
        batch.end();
    }

    public void resize(){
        camBackGround = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camBackGround.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        camBackGround.update();
        batch.setProjectionMatrix(camBackGround.combined);
    }


    public void dispose(){
        batch.dispose();
        texture.dispose();
    }
}
