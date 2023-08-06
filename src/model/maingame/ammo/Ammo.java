package model.maingame.ammo;

import control.GameConstStr;
import model.FlyingObject;

public abstract class Ammo extends FlyingObject {
    public Ammo(String belongTo, int x, int y) {
        this.belongTo = belongTo;
        objX = x;
        objY = y;
        objectName = GameConstStr.AMMO_NAME;
    }

    protected String belongTo;
    protected abstract void hitFeedback();
}
