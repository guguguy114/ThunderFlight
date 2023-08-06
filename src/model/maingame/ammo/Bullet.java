package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameConstStr;
import model.Game;

import java.util.ArrayList;

public class Bullet extends Ammo{

    public Bullet(String belongTo, int x, int y) {
        super(belongTo, x, y);
        objImg = GameConstResourceUtil.FRIEND_BULLET_LIGHT;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
        animationList = new ArrayList<>();
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_LIGHT);
    }

    @Override
    public void move() {
        if (belongTo.equals(GameConstStr.FRIENDLY)){
            objY -= 5;
        }
        if (belongTo.equals(GameConstStr.ENEMY)){
            objY += 5;
        }
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void changeAnimation() {
        objImg = animationList.get(animationOrder);
        animationOrder++;
        if (animationOrder == animationList.size()){
            animationOrder = 0;
        }
    }

    @Override
    protected void hitFeedback() {

    }
}
