package com.space_feiter.control;

import com.space_feiter.model.Mess;

public class HandlePermissionMessenge extends HandleMessenge {
    @Override
    public String handle(Mess mess) {
        mess.frameNumsLive--;
        if (mess.frameNumsLive<1){
            mess.need = false;
        }
        return mess.getMess();
    }
}
