package com.space_feiter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.control.ControllPlayer;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Button;

public class ControllForAndroid extends ControllPlayer {
    private Texture textureLeft;
    private Texture textureRight;
    private Texture textureFire;
    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonFire;


    public void initialise(){
        textureLeft = new Texture(Gdx.files.internal("left.png"));
        float xMax = Gdx.graphics.getWidth()*HandlerStatOfGame.zoom/2f;
        float yMax = Gdx.graphics.getHeight()*HandlerStatOfGame.zoom/2f;

        System.out.println(xMax);
        textureLeft.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        buttonLeft = new Button(textureLeft,-(xMax-0.5f),-(yMax-1f),3f,3f);
        textureRight = new Texture(Gdx.files.internal("right.png"));
        textureRight.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        buttonRight = new Button(textureRight,-(xMax-5f),-(yMax-1f),3f,3f);
        textureFire = new Texture(Gdx.files.internal("butonfire.png"));
        textureFire.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        buttonFire = new Button(textureFire,xMax-3f,-(yMax-1f),3f,3f);
        inputProcessor = new HandlerInput();

        buttons.add(buttonLeft);
        buttons.add(buttonFire);
        buttons.add(buttonRight);
    }

    @Override
    public void draw(SpriteBatch bath) {
        super.draw(bath);
        buttonLeft.draw(bath);
        buttonRight.draw(bath);
        buttonFire.draw(bath);
    }

    @Override
    protected void handle() {
        contolLeft = buttonLeft.isPressed;
        controlRicht = buttonRight.isPressed;
        controlFire = buttonFire.isPressed;
    }
}
