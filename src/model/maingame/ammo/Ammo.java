package model.maingame.ammo;

import model.maingame.FlyingObject;

public abstract class Ammo extends FlyingObject {
    protected String belongTo;
    protected abstract void hitFeedback();
}
