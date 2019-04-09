package com.space_feiter.model;

import com.badlogic.gdx.graphics.Color;
import com.space_feiter.control.handle.HandleMessenge;

public class Messeng {
    String mess;
    float x;
    float y;
    public boolean need;
    public float timeAlive;
    Color color;


    HandleMessenge handl;

    public Messeng(String mess, HandleMessenge handl , float x, float y){
        this.mess = mess;
        this.x = x;
        this.y = y;
        this.handl = handl;
        need = true;
    }

    public Messeng(String mess, float timeAlive, HandleMessenge handl , float x, float y){
        this.mess = mess;
        this.x = x;
        this.y = y;
        this.handl = handl;
        this.timeAlive = timeAlive;
        need = true;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getMess() {
        return mess;
    }

    public void handle() {
        mess =  handl.handle(this);
    }
}
