package model.maingame.ammo;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;

public abstract class Ammo extends FlyingObject {
    public Ammo(String belongTo, int x, int y) {
        this.belongTo = belongTo;
        objX = x;
        objY = y;
        objectName = GameConstStr.AMMO_NAME;
    }

    protected String belongTo;

    public String getBelongTo() {
        return belongTo;
    }

    public abstract void hitFeedback(Game game);
}
