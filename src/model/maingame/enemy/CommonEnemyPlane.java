package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;
import model.maingame.ammo.Bullet;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.Random;

public class CommonEnemyPlane extends EnemyPlane{

    public CommonEnemyPlane(Image image, int x, int y, Game game) {
        super(image, x, y, game);
        //System.out.println("creating_common_plane");
        objectWidth = GameConstDataUtil.COMMON_ENEMY_PLANE_WIDTH;
        objectHeight = GameConstDataUtil.COMMON_ENEMY_PLANE_HEIGHT;
        attackTimer = new AttackTimer(game, this);
        attackTimer.getTimer().start();
        speedY = 1 + new Random().nextInt(3);
    }

    @Override
    public void move() {
        objY += speedY;
        atkPointX = objX + objectWidth / 2;
        actPointY = objY + objectHeight;
    }

    @Override
    public void attack(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        //System.out.println("attacking");
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this));
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
}
