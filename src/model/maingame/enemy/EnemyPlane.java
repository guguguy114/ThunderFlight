package model.maingame.enemy;

import control.GameConstStr;
import control.timer.AnimationTimer;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.ammo.Ammo;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * 敌机总类
 */
public abstract class EnemyPlane extends FlyingObject {
    protected final boolean randomSpeed;
    protected int score;
    public EnemyPlane(Image image, int x, int y, Game game) {
        randomSpeed = game.getGameLevel().isRandomSpeed();
        deadImgList = new ArrayList<>();
        className = GameConstStr.ENEMY_PLANE_NAME;
        img = image;
        objX = x;
        objY = y;
        animationList = new ArrayList<>();
        animationTimer = new AnimationTimer(game);
        setAnimation();
    }

    @Override
    public void dead(Game game) {
        if (hitBle){
            game.getPlayer().setScore(game.getPlayer().getScore() + score);
            stopFlyingObject();
        }
        hitBle = false;
        animationTimer.getTimer().stop();
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
        attackTimer.getTimer().stop();
    }

    public abstract void hitFeedback(Game game);

    @Override
    protected void setAnimation() {

    }

    @Override
    public void hitDetect(Game game) {
        if (hitBle){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()) {
                for (FlyingObject flyingObject : totalList) {
                    if (intersect(flyingObject)) {
                        if (flyingObject instanceof Ammo && ((Ammo) flyingObject).getBelongTo().equals(GameConstStr.FRIEND)) {
                            ((Ammo) flyingObject).hitFeedback(game, this);
                            if (life == 0) {
                                dead(game);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void deadCount(Game game);
}
