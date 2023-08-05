package model;

import control.GameConstResourceUtil;
import control.timer.AnimationTimer;
import control.timer.GlobalTimer;
import view.UI;

public class Game {
    private final UI ui;
    private final GlobalTimer globalTimer;
    private Player player;
    private GameLevel gameLevel;
    private int gameMode;
    private String operateWay;
    private int globalTime;
    private AnimationTimer animationTimer;

    public Game() {
        globalTime = 0;
        gameLevel = new GameLevel(new BackGround(GameConstResourceUtil.BG1), 20, 20);
        globalTimer = new GlobalTimer(this);
        animationTimer = new AnimationTimer(this);
        ui = new UI(this);

    }

    public String getOperateWay() {
        return operateWay;
    }

    public void setOperateWay(String operateWay) {
        this.operateWay = operateWay;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(AnimationTimer animationTimer) {
        this.animationTimer = animationTimer;
    }

    public int getGlobalTime() {
        return globalTime;
    }

    public void setGlobalTime(int globalTime) {
        this.globalTime = globalTime;
    }

    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }

    public Player getPlayer() {
        return player;
    }

    public UI getUi() {
        return ui;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }
}
