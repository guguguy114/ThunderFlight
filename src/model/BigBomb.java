package model;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.DeadTimer;

import java.util.ArrayList;

public class BigBomb extends FlyingObject{
    public BigBomb(Game game) {
        objX = 0;objY = 0;
        width = GameConstDataUtil.GAME_PANEL_WIDTH;
        height = GameConstDataUtil.GAME_PANEL_HEIGHT;
        deadImgList = new ArrayList<>();
        className = GameConstStr.BOMB_NAME;
        setDeadImages();
        dead(game);
    }

    @Override
    public void move(Game game) {

    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {
        Music dead = new Music(Music.USE_BOMB);
        dead.startMusic();
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
    }

    @Override
    public void changeAnimation() {

    }

    @Override
    public void hitDetect(Game game) {

    }

    @Override
    protected void setDeadImages() {
        deadImgList.add(GameConstResourceUtil.BIG_BOMB_1);
        deadImgList.add(GameConstResourceUtil.BIG_BOMB_2);
        deadImgList.add(GameConstResourceUtil.BIG_BOMB_3);
        deadImgList.add(GameConstResourceUtil.BIG_BOMB_4);
    }

    @Override
    protected void setAnimation() {

    }
}
