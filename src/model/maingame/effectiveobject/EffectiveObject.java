package model.maingame.effectiveobject;

import control.GameConstStr;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.Music;
import view.gamewindows.GamePanel;

import java.util.ArrayList;
import java.util.Random;

/**
 * 增益效果总类
 */
public abstract class EffectiveObject extends FlyingObject {
    protected Game game;
    protected String direct;//移动方向
    protected Music hitMusic;
    public EffectiveObject(Game game, int x, int y) {
        this.game = game;
        objX = x;
        objY = y;
        className = GameConstStr.EFFECT_OBJECT_NAME;
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (x > gamePanel.getWidth() / 2){
            direct = GameConstStr.LEFT;
        }else if (x < gamePanel.getWidth() / 2){
            direct = GameConstStr.RIGHT;
        }
        speedX = 4 + new Random().nextInt(3);
        speedY = 1 + new Random().nextInt(3);
        deadImgList = new ArrayList<>();
        deadTimer = new DeadTimer(game, this);
    }
    @Override
    public void move(Game game) {
        GamePanel gamePanel = this.game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (objX <= 0){
            direct = GameConstStr.RIGHT;
        }
        if (objX + width >= gamePanel.getWidth()){
            direct = GameConstStr.LEFT;
        }
        switch (direct){
            case GameConstStr.RIGHT:
                objX += speedX;
                objY += speedY;
                break;
            case GameConstStr.LEFT:
                objX -= speedX;
                objY += speedY;
                break;
        }
    }

    /**
     * 得到后的效果
     */
    public abstract void hitFeedback();

    @Override
    public void hitDetect(Game game) {

    }

    @Override
    protected void setAnimation() {

    }

    @Override
    public void dead(Game game) {
        hitMusic.startMusic();
        out = true;
        hitBle = false;
        deadTimer.getTimer().start();
    }
}
