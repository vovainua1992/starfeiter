package com.space_feiter.control;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.space_feiter.model.Button;

public abstract class ControllPlayer {

    public static Array<Button> buttons = new Array<Button>();
    public static boolean contolLeft,controlRicht,controlFire,controlNextSound,controlBackSound,controlLopingSound;
    public InputProcessor inputProcessor;

    public abstract void initialise();

   public void draw(SpriteBatch bath){
            handle();
   }

   protected abstract void handle();

}
