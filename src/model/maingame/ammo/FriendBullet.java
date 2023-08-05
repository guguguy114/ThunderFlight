package model.maingame.ammo;

import control.GameConstResourceUtil;
import model.Game;

import java.util.ArrayList;

public class FriendBullet extends Ammo{

    public FriendBullet(String belongTo, int x, int y) {
        super(belongTo, x, y);
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
        animationList = new ArrayList<>();
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_LIGHT);
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_DARK);

    }

    @Override
    public void move() {
        objY -= 5;
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
