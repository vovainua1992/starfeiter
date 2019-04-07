package com.space_feiter.control;

import com.space_feiter.model.Mess;

public class HandleScoreMessenge extends HandleMessenge {
String str;
 static int numsScore = 0;

    public HandleScoreMessenge(String s){
        str=s;
    }
    @Override
    public String handle(Mess mess) {
        String s = str +" - "+ numsScore;
        numsScore++;
        return s;
    }
}
