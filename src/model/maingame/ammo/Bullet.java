package model.maingame.ammo;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import model.FlyingObject;
import model.Game;
import model.maingame.enemy.EnemyPlane;

import java.util.ArrayList;

public class Bullet extends Ammo {

    /**
     * 敌机使用的构造函数
     *
     * @param belongTo  属于哪一阵营
     * @param x         生成位置x
     * @param y         生成位置y
     * @param enemyFrom 创建该子弹的飞行物
     */
    public Bullet(String belongTo, int x, int y, EnemyPlane enemyFrom, int direct) {
        this(belongTo, x, y, direct);
        speedY = enemyFrom.getSpeedY() + 2;
        speedX = enemyFrom.getSpeedX() + 2;
        damage = 1;
    }

    /**
     * 英雄机发射子弹用的构造函数
     *
     * @param belongTo 属于的阵营
     * @param x        生成位置x
     * @param y        生成位置y
     */
    public Bullet(String belongTo, int x, int y, int direct) {
        super(belongTo, x, y);
        img = GameConstResourceUtil.FRIEND_BULLET_LIGHT;
        width = img.getWidth(null);
        height = img.getHeight(null);
        animationList = new ArrayList<>();
        if (belongTo.equals(GameConstStr.FRIEND)){
            speedY = 5;
        }
        damage = 1;
        setDirect(direct);
    }

    @Override
    public void move(Game game) {
        if (up) {
            objY -= speedY;
        }
        if (down) {
            objY += speedY;
        }
        if (right){
            objX += speedX;
        }
        if (left){
            objX -= speedX;
        }
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {
        super.dead(game);

    }

    @Override
    public void changeAnimation() {
        //img = animationList.get(animationOrder);
        //animationOrder++;
        //if (animationOrder == animationList.size()) {
        //    animationOrder = 0;
        //}
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

    private void setDirect(int direct){
        switch (direct){
            case GameConstDataUtil.DIRECT_UP:
                up = true;
                break;
            case GameConstDataUtil.DIRECT_DOWN:
                down = true;
                break;
            case GameConstDataUtil.DIRECT_RIGHT:
                right = true;
                break;
            case GameConstDataUtil.DIRECT_LEFT:
                left = true;
                break;
            case GameConstDataUtil.DIRECT_UP_AND_RIGHT:
                up = true;
                right = true;
                break;
            case GameConstDataUtil.DIRECT_UP_AND_LEFT:
                up = true;
                left = true;
                break;
            case GameConstDataUtil.DIRECT_DOWN_AND_RIGHT:
                down = true;
                right = true;
                break;
            case GameConstDataUtil.DIRECT_DOWN_AND_LEFT:
                down = true;
                left = true;
                break;
        }
    }
}
