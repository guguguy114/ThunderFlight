package model.maingame.ammo;

import control.GameConstResourceUtil;
import control.GameController;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.enemy.EnemyPlane;

public class EnemyPromoteBullet extends Ammo{
    public EnemyPromoteBullet(String belongTo, int x, int y, EnemyPlane enemyFrom) {
        super(belongTo, x, y);
        objImg = GameConstResourceUtil.PROMOTE_ENEMY_BULLET;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
        damage = 2;
        speedY = enemyFrom.getSpeedY() + 2;
    }

    @Override
    public void move() {
        objY += speedY;

    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
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
        objIn.setLife(objIn.getLife() - damage);
        GameController.removeAmmo(game, this);
    }
}
