package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameController;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.enemy.EnemyPlane;

import java.util.ArrayList;

public class Bullet extends Ammo{

    public Bullet(String belongTo, int x, int y, EnemyPlane enemyFrom) {
        this(belongTo, x, y);
        speedY = enemyFrom.getSpeedY() + 2;
        damage = 1;
    }
    public Bullet(String belongTo, int x, int y){
        super(belongTo, x, y);
        objImg = GameConstResourceUtil.FRIEND_BULLET_LIGHT;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
        animationList = new ArrayList<>();
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_LIGHT);
        speedY = 5;
        damage = 1;
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
    public void dead(Game game) {
        System.out.println("ammo_dead");
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
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
    protected void setDeadImages() {
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_1);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_2);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_3);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_4);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_5);
    }

    @Override
    public void hitFeedback(Game game, FlyingObject objIn) {
        objIn.setLife(objIn.getLife() - damage);
        GameController.removeAmmo(game, this);
    }
}
