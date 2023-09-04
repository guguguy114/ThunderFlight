package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;
import model.GameLevel;
import model.Music;
import model.maingame.ammo.EnemyPromoteBullet;
import view.gamewindows.GamePanel;

import java.util.Random;

public class PromotedEnemyPlane extends EnemyPlane {
    public PromotedEnemyPlane(int x, int y, Game game) {
        super(GameConstResourceUtil.PROMOTE_ENEMY_PLANE, x, y, game);
        //System.out.println("creating_common_plane");
        setDeadImages();
        width = GameConstDataUtil.PROMOTE_ENEMY_PLANE_WIDTH;
        height = GameConstDataUtil.PROMOTE_ENEMY_PLANE_HEIGHT;
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
        down = true;
        game.getGameLevel().setPromoteSummonCount(game.getGameLevel().getPromoteSummonCount() + 1);
    }

    @Override
    public void move(Game game) {
        if (down){
            objY += speedY;
        }
        atkPointX = objX + width / 2;
        actPointY = objY + height;
    }

    @Override
    public void attack(Game game) {
        Music fire = new Music(Music.FIRE);
        fire.startMusic();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getAmmoList().add(new EnemyPromoteBullet(GameConstStr.ENEMY, atkPointX, actPointY, this));
    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        Music dead = new Music(Music.ENEMY_DOWN);
        dead.startMusic();
        deadCount(game);
    }

    @Override
    public void hitFeedback(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getHeroPlane().setLife(gamePanel.getHeroPlane().getLife() - 1);
    }

    @Override
    public void deadCount(Game game) {
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.setPromoteDeadCount(gameLevel.getPromoteDeadCount() + 1);
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
