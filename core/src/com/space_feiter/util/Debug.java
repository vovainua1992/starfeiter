package com.space_feiter.util;

public class Debug {
    boolean itsDebug = true;


    public  void Log(String messange){
        if (itsDebug){
            System.out.println(messange);
        }
    }



}
