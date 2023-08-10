package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import control.timer.DeadTimer;
import model.Game;
import model.maingame.ammo.Bullet;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.Random;

public class CommonEnemyPlane extends EnemyPlane{

    public CommonEnemyPlane(Image image, int x, int y, Game game) {
        super(image, x, y, game);
        //System.out.println("creating_common_plane");
        setDeadImages();
        objectWidth = GameConstDataUtil.COMMON_ENEMY_PLANE_WIDTH;
        objectHeight = GameConstDataUtil.COMMON_ENEMY_PLANE_HEIGHT;
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
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this));
    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        game.getGameLevel().setCommonCount(game.getGameLevel().getCommonCount() + 1);
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
        if (objImg == GameConstResourceUtil.COMMON_ENEMY_PLANE_1){
            deadImgList.add(GameConstResourceUtil.COMMON_ENEMY_DEAD_1);
        }else if (objImg == GameConstResourceUtil.COMMON_ENEMY_PLANE_2){
            deadImgList.add(GameConstResourceUtil.COMMON_ENEMY_DEAD_2);
        }
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_1);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_2);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_3);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_4);
        deadImgList.add(GameConstResourceUtil.ENEMY_DEAD_IMAGE_5);
    }
}
