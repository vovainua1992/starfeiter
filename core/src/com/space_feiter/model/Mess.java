package com.space_feiter.model;

import com.space_feiter.control.HandleMessenge;

public class Mess {
    String mess;
    float x;
    float y;
    public boolean need;
    public int frameNumsLive;


    HandleMessenge handl;

    public Mess(String mess, HandleMessenge handl , float x, float y){
        this.mess = mess;
        this.x = x;
        this.y = y;
        this.handl = handl;
        need = true;
    }

    public Mess(String mess,int frameNumsLive, HandleMessenge handl , float x, float y){
        this.mess = mess;
        this.x = x;
        this.y = y;
        this.handl = handl;
        this.frameNumsLive = frameNumsLive;
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
