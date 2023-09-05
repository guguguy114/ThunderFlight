package model;

import control.GameConstResourceUtil;

public class Point extends FlyingObject{
    public Point() {
        img = GameConstResourceUtil.POINT;
        width = img.getWidth(null);
        height = img.getHeight(null);
    }

    @Override
    public void move(Game game) {

    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    public void hitDetect(Game game) {

    }

    @Override
    protected void setDeadImages() {

    }

    @Override
    protected void setAnimation() {

    }

    public void setPos(int x, int y){
        objX = x;
        objY = y;
    }
}
