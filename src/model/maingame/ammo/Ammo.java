package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameConstStr;
import model.FlyingObject;

public abstract class Ammo extends FlyingObject {
    public Ammo(String belongTo, int x, int y) {
        this.belongTo = belongTo;
        objImg = GameConstResourceUtil.FRIEND_BULLET_DARK;
        objX = x;
        objY = y;
        objectName = GameConstStr.AMMO_NAME;
    }

    protected String belongTo;
    protected abstract void hitFeedback();
}
