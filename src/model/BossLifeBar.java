package model;

import control.GameConstResourceUtil;

import java.awt.*;

public class BossLifeBar extends FlyingObject{
    private FlyingObject belongTo;
    public BossLifeBar(FlyingObject objIn) {
        img = GameConstResourceUtil.LIFE_BAR_BLACK;
        width = 510;
        height = 30;
        belongTo = objIn;
        objX = objIn.objX - (width - objIn.width / 2);
        objY = objIn.objY - 20;
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

    @Override
    public void draw(Graphics g, Game game) {
        super.draw(g, game);
        int lifeRemain = (int) ((width - 10) * ((double)belongTo.life / (double) game.getGameLevel().getBossLife()));
        g.drawImage(GameConstResourceUtil.LIFE_BAR_RED, objX + 5, objY + 5, objX + 5 + lifeRemain, objY + height - 5, 0, 0, width - 10, height - 10, null);
        //System.out.println("draw");
    }

    public void setPos(FlyingObject objIn){
        objX = objIn.objX - (width - objIn.width) / 2;
        objY = objIn.objY - 20;
        System.out.println(objX);
    }
}
