package model.maingame.enemy;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;

import java.awt.*;
import java.util.ArrayList;

public abstract class EnemyPlane extends FlyingObject {
    protected final boolean randomSpeed;
    protected int score;
    private int type;
    public EnemyPlane(Image image, int x, int y, Game game) {
        randomSpeed = game.getGameLevel().isRandomSpeed();
        deadImgList = new ArrayList<>();
        objectName = GameConstStr.ENEMY_PLANE_NAME;
        objImg = image;
        objX = x;
        objY = y;
    }

    @Override
    public void dead(Game game) {
        game.getPlayer().setScore(game.getPlayer().getScore() + score);
        stopFlyingObject();
        hitBal = false;
    }

    public abstract void hitFeedback(Game game);
}
