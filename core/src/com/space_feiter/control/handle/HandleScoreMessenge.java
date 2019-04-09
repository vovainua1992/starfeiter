package com.space_feiter.control.handle;

import com.space_feiter.control.HandlerStatOfGame;
import com.space_feiter.model.Messeng;

public class HandleScoreMessenge extends HandleMessenge {
String str;

    public HandleScoreMessenge(String s){
        str=s;
    }
    @Override
    public String handle(Messeng messeng) {
        String s = str +" - "+ HandlerStatOfGame.score;
        return s;
    }
}
