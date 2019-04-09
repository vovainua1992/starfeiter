package com.space_feiter.control.handle;

import com.space_feiter.model.Messeng;
import com.space_feiter.viev.GameScreen;

public class HandlePermissionMessenge extends HandleMessenge {
    @Override
    public String handle(Messeng messeng) {
        messeng.timeAlive = messeng.timeAlive -GameScreen.deltaCF;
        if (!(messeng.timeAlive>0)){
            messeng.need = false;
        }
        return messeng.getMess();
    }
}
