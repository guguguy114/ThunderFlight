package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameController;
import model.Game;
import model.maingame.enemy.EnemyPlane;

import java.util.ArrayList;

public class Bullet extends Ammo{

    public Bullet(String belongTo, int x, int y, EnemyPlane enemyFrom) {
        this(belongTo, x, y);
        speedY = enemyFrom.getSpeedY() + 2;
    }
    public Bullet(String belongTo, int x, int y){
        super(belongTo, x, y);
        objImg = GameConstResourceUtil.FRIEND_BULLET_LIGHT;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
        animationList = new ArrayList<>();
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_LIGHT);
        speedY = 5;
    }

    @Override
    public void move() {
        if (belongTo.equals(GameConstStr.FRIEND)){
            objY -= speedY;
        }
        if (belongTo.equals(GameConstStr.ENEMY)){
            objY += speedY;
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
    public void hitFeedback(Game game) {
        GameController.removeAmmo(game, this);
    }
}
