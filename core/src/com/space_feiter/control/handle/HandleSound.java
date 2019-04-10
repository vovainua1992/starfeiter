package com.space_feiter.control.handle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.space_feiter.model.GameObject;

public class HandleSound {
    public static Sound piu;
    public static Sound gameOver;
    public static Sound boom;
    private Music[] listBackgraund = new Music[4];
    int numMusicPlayed = 0;
    public float value = 0.3f;

    public HandleSound(){
        piu = Gdx.audio.newSound(Gdx.files.internal("sound/piu.wav"));
        gameOver = Gdx.audio.newSound(Gdx.files.internal("sound/game_over.wav"));
        boom = Gdx.audio.newSound(Gdx.files.internal("sound/bom_aster.wav"));
        listBackgraund[0] = Gdx.audio.newMusic(Gdx.files.internal("sound/background1.mp3"));
        listBackgraund[1] = Gdx.audio.newMusic(Gdx.files.internal("sound/background2.mp3"));
        listBackgraund[2] = Gdx.audio.newMusic(Gdx.files.internal("sound/background3.mp3"));
        listBackgraund[3] = Gdx.audio.newMusic(Gdx.files.internal("sound/background4.mp3"));
    }

    public void nextTrack(){
        listBackgraund[numMusicPlayed].stop();
        handle();
    }

   public void handle(){
       if (!listBackgraund[numMusicPlayed].isPlaying()){
           if (numMusicPlayed<3){
           numMusicPlayed++;
           listBackgraund[numMusicPlayed].play();
           listBackgraund[numMusicPlayed].setVolume(value);
           }else {
               numMusicPlayed = 0;
               listBackgraund[numMusicPlayed].play();
               listBackgraund[numMusicPlayed].setVolume(value);
           }
       }
    }

}
