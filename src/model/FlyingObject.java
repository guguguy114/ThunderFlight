package model;

import java.awt.*;

public abstract class FlyingObject {
    protected int objX, objY;
    protected Image objImg;
    protected int speedX;
    protected int speedY;

    protected abstract void move();

    public Image getObjImg() {
        return objImg;
    }

    public void setObjImg(Image objImg) {
        this.objImg = objImg;
    }

    public int getObjX() {
        return objX;
    }

    public void setObjX(int objX) {
        this.objX = objX;
    }

    public int getObjY() {
        return objY;
    }

    public void setObjY(int objY) {
        this.objY = objY;
    }
}
