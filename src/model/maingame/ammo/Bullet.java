package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.enemy.EnemyPlane;

import java.util.ArrayList;

public class Bullet extends Ammo{

    /**
     * 敌机使用的构造函数
     * @param belongTo 属于哪一阵营
     * @param x 生成位置x
     * @param y 生成位置y
     * @param enemyFrom 创建该子弹的飞行物
     */
    public Bullet(String belongTo, int x, int y, EnemyPlane enemyFrom) {
        this(belongTo, x, y);
        speedY = enemyFrom.getSpeedY() + 2;
        damage = 1;
    }

    /**
     * 英雄机发射子弹用的构造函数
     * @param belongTo 属于的阵营
     * @param x 生成位置x
     * @param y 生成位置y
     */
    public Bullet(String belongTo, int x, int y){
        super(belongTo, x, y);
        img = GameConstResourceUtil.FRIEND_BULLET_LIGHT;
        width = img.getWidth(null);
        height = img.getHeight(null);
        animationList = new ArrayList<>();
        animationList.add(GameConstResourceUtil.FRIEND_BULLET_LIGHT);
        up = true;
        down = true;
        speedY = 5;
        damage = 1;
    }

    @Override
    public void move(Game game) {
        if (belongTo.equals(GameConstStr.FRIEND)){
            if (up){
                objY -= speedY;
            }
        }
        if (belongTo.equals(GameConstStr.ENEMY)){
            if (down){
                objY += speedY;
            }
        }
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
    }

    @Override
    public void changeAnimation() {
        img = animationList.get(animationOrder);
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
        super.hitFeedback(game, objIn);
    }
}
