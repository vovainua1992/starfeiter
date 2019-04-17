package com.space_feiter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.space_feiter.control.ControllPlayer;
import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.viev.FrameRate;
import com.space_feiter.viev.GameScreen;
import com.space_feiter.viev.TestScreen;

public class Main extends Game {
    private Screen gameScreen;


public Main(ControllPlayer controllPlayer){
    HandlerStatOfGame.controllPlayer = controllPlayer;
}

    @Override
    public void create() {
        gameScreen = new GameScreen();

        setScreen(gameScreen);
    }
}
