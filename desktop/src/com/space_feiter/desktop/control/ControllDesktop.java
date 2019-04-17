package com.space_feiter.desktop.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.space_feiter.control.ControllPlayer;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Button;

public class ControllDesktop extends ControllPlayer {


    public void initialise(){
        inputProcessor = new InputDesktop();
    }

    @Override
    public void draw(SpriteBatch bath) {
        super.draw(bath);
    }

    @Override
    protected void handle() {

    }
}
