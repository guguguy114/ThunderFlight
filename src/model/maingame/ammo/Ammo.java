package model.maingame.ammo;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;

import java.util.ArrayList;

public abstract class Ammo extends FlyingObject {
    protected int damage;
    public Ammo(String belongTo, int x, int y) {
        this.belongTo = belongTo;
        objX = x;
        objY = y;
        objectName = GameConstStr.AMMO_NAME;
        deadImgList = new ArrayList<>();
        setDeadImages();
    }

    protected String belongTo;

    public String getBelongTo() {
        return belongTo;
    }

    public abstract void hitFeedback(Game game, FlyingObject objIn);
}
