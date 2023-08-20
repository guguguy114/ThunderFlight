package model.maingame.ammo;

import control.GameConstResourceUtil;
import model.FlyingObject;
import model.Game;
import model.maingame.enemy.EnemyPlane;

/**
 * 精英敌机
 */
public class EnemyPromoteBullet extends Ammo{
    public EnemyPromoteBullet(String belongTo, int x, int y, EnemyPlane enemyFrom) {
        super(belongTo, x, y);
        img = GameConstResourceUtil.PROMOTE_ENEMY_BULLET;
        width = img.getWidth(null);
        height = img.getHeight(null);
        damage = 2;
        speedY = enemyFrom.getSpeedY() + 2;
        down = true;
    }

    @Override
    public void move(Game game) {
        if (down){
            objY += speedY;
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
