package model.maingame;

import java.awt.*;

public abstract class FlyingObject {
    protected int objX, objY;
    protected Image objImg;
    protected int speedX;
    protected int speedY;
    protected abstract void move();
}
