package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;
import model.GameLevel;
import model.Music;
import model.maingame.ammo.Bullet;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.Random;

public class CommonEnemyPlane extends EnemyPlane{

    public CommonEnemyPlane(Image image, int x, int y, Game game) {
        super(image, x, y, game);
        //System.out.println("creating_common_plane");
        setDeadImages();
        width = GameConstDataUtil.COMMON_ENEMY_PLANE_WIDTH;
        height = GameConstDataUtil.COMMON_ENEMY_PLANE_HEIGHT;
        objectName = GameConstStr.COMMON_ENEMY_PLANE_NAME;
        score = 1;
        attackTimer = new AttackTimer(game, this, GameConstStr.ENEMY);
        attackTimer.getTimer().start();
        if (randomSpeed){
            speedY = 1 + new Random().nextInt(3);
        }else {
            speedY = game.getGameLevel().getEnemySpeedY();
        }

        life = 1;
        down = true;
        game.getGameLevel().setCommonSummonCount(game.getGameLevel().getCommonSummonCount() + 1);
        speedX = 0;
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
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_DOWN));
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
        gameLevel.setCommonDeadCount(gameLevel.getCommonDeadCount() + 1);
    }

    @Override
    public void changeAnimation() {

    }

    public static Image randomImg(){
        Random r = new Random();
        int key = r.nextInt(2);
        switch (key){
            case 0:
                //System.out.println("return_picture_1");
                return GameConstResourceUtil.COMMON_ENEMY_PLANE_1;
            case 1:
                //System.out.println("return_picture_2");
                return GameConstResourceUtil.COMMON_ENEMY_PLANE_2;
            default:
                return null;
        }
    }

    @Override
    protected void setDeadImages(){
        if (img == GameConstResourceUtil.COMMON_ENEMY_PLANE_1){
            deadImgList.add(GameConstResourceUtil.COMMON_ENEMY_DEAD_1);
        }else if (img == GameConstResourceUtil.COMMON_ENEMY_PLANE_2){
            deadImgList.add(GameConstResourceUtil.COMMON_ENEMY_DEAD_2);
        }
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_1);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_2);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_3);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_4);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_5);
    }
}
