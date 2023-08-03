package model.maingame.ammo;

import model.FlyingObject;

public abstract class Ammo extends FlyingObject {
    protected String belongTo;
    protected abstract void hitFeedback();
}
