package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import control.timer.DeadTimer;
import model.Game;
import model.maingame.ammo.EnemyPromoteBullet;
import view.gamewindows.GamePanel;

import java.util.Random;

public class PromotedEnemyPlane extends EnemyPlane {
    public PromotedEnemyPlane(int x, int y, Game game) {
        super(GameConstResourceUtil.PROMOTE_ENEMY_PLANE, x, y, game);
        //System.out.println("creating_common_plane");
        setDeadImages();
        objectWidth = GameConstDataUtil.PROMOTE_ENEMY_PLANE_WIDTH;
        objectHeight = GameConstDataUtil.PROMOTE_ENEMY_PLANE_HEIGHT;
        objectName = GameConstStr.PROMOTE_ENEMY_PLANE_NAME;
        score = 2;
        attackTimer = new AttackTimer(game, this, GameConstStr.ENEMY);
        attackTimer.getTimer().start();
        if (randomSpeed){
            speedY = 1 + new Random().nextInt(3);
        }else {
            speedY = game.getGameLevel().getEnemySpeedY();
        }

        life = 2;
        isDown = true;
    }

    @Override
    public void move() {
        if (isDown){
            objY += speedY;
        }
        atkPointX = objX + objectWidth / 2;
        actPointY = objY + objectHeight;
    }

    @Override
    public void attack(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getAmmoList().add(new EnemyPromoteBullet(GameConstStr.ENEMY, atkPointX, actPointY, this));
    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        game.getGameLevel().setPromoteCount(game.getGameLevel().getPromoteCount() + 1);
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
        attackTimer.getTimer().stop();
    }

    @Override
    public void hitFeedback(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getHeroPlane().setLife(gamePanel.getHeroPlane().getLife() - 1);
    }

    @Override
    public void changeAnimation() {

    }

    @Override
    protected void setDeadImages() {
        deadImgList.add(GameConstResourceUtil.PROMOTE_ENEMY_DEAD);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_1);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_2);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_3);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_4);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_5);
    }
}
