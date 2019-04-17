package com.space_feiter.desktop.control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.space_feiter.control.ControllPlayer;

public class InputDesktop implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        if (keycode== Input.Keys.LEFT){
            ControllPlayer.contolLeft = true;
        }
        if (keycode==Input.Keys.RIGHT)
            ControllPlayer.controlRicht = true;
        if (keycode==Input.Keys.SPACE)
            ControllPlayer.controlFire = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode==Input.Keys.LEFT)
            ControllPlayer.contolLeft = false;
        if (keycode==Input.Keys.RIGHT)
            ControllPlayer.controlRicht = false;
        if (keycode==Input.Keys.SPACE)
            ControllPlayer.controlFire = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
