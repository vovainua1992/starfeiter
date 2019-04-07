package com.space_feiter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.space_feiter.viev.FrameRate;
import com.space_feiter.viev.GameScreen;

public class Main extends Game {
    private Screen gameScreen;



    @Override
    public void create() {
        gameScreen = new GameScreen();

        setScreen(gameScreen);
    }
}
