package com.space_feiter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.space_feiter.control.ControllPlayer;
import com.space_feiter.control.HandlerStatOfGame;

public class HandlerInput implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float y = -((screenY-Gdx.graphics.getHeight()/2f)* HandlerStatOfGame.zoom);
        float x = ((screenX-Gdx.graphics.getWidth()/2f)*HandlerStatOfGame.zoom);
        for (int i = ControllPlayer.buttons.size; i>0; i--){
            if (ControllPlayer.buttons.get(i-1).getBounds().contains(x,y)){
                ControllPlayer.buttons.get(i-1).isPressed = true;
                ControllPlayer.buttons.get(i-1).numToch = pointer;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (int i = ControllPlayer.buttons.size;i>0;i--){
            if (ControllPlayer.buttons.get(i-1).numToch==pointer){
                ControllPlayer.buttons.get(i-1).isPressed = false;
                ControllPlayer.buttons.get(i-1).numToch = -1;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
