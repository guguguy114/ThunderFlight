package model.maingame.effectiveobject;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;
import view.gamewindows.GamePanel;

import java.util.Random;

public abstract class EffectiveObject extends FlyingObject {
    protected Game game;
    protected String direct;
    public EffectiveObject(Game game, int x, int y) {
        this.game = game;
        objX = x;
        objY = y;
        objectName = GameConstStr.EFFECT_OBJECT_NAME;
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (x > gamePanel.getWidth() / 2){
            direct = GameConstStr.LEFT;
        }else if (x < gamePanel.getWidth() / 2){
            direct = GameConstStr.RIGHT;
        }
        speedX = 4 + new Random().nextInt(3);
        speedY = 1 + new Random().nextInt(3);
    }
    @Override
    public void move() {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (objX <= 0){
            direct = GameConstStr.RIGHT;
        }
        if (objX + objectWidth >= gamePanel.getWidth()){
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

    public abstract void hitFeedback();
}
