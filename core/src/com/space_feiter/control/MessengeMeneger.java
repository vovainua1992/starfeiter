package com.space_feiter.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.space_feiter.control.handle.HandlePermissionMessenge;
import com.space_feiter.control.handle.HandleScoreMessenge;
import com.space_feiter.model.Messeng;

import java.util.ArrayList;

public class MessengeMeneger implements Disposable {
  private static BitmapFont font;
  private static SpriteBatch batch;

  private   static ArrayList<Messeng> messes = new ArrayList<Messeng>();
  private static ArrayList<Messeng> deleteList = new ArrayList<Messeng>();


    public MessengeMeneger() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    public static void setPermissionMesenge(String mesenge, float numsFrameLive, float posX, float posY) {
        messes.add(new Messeng(mesenge, numsFrameLive, new HandlePermissionMessenge(), posX, posY));

    }

    public static void setStaticMess(String mess, float x, float y) {
        messes.add(new Messeng(mess, new HandleScoreMessenge(mess), x, y));
    }

    private static void renderAll() {
        for (int i = messes.size(); i > 0; i--) {
            font.draw(batch, messes.get(i - 1).getMess(), messes.get(i - 1).getX(), messes.get(i - 1).getY());
            messes.get(i - 1).handle();
            if (!messes.get(i - 1).need) {
                deleteList.add(messes.get(i - 1));
            }
        }
        messes.removeAll(deleteList);
    }

    public static void render() {
        batch.begin();
        renderAll();
        batch.end();
    }

    public void dispose() {
        font.dispose();
        batch.dispose();
    }

    public void reize() {

    }
}