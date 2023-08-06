package model;

import control.GameConstResourceUtil;
import control.timer.Timers;
import view.UI;

public class Game {
    private final UI ui;
    private Player player;
    private GameLevel gameLevel;
    private int gameMode;
    private String operateWay;
    private int globalTime;
    private final Timers timers;

    public Game() {
        globalTime = 0;
        gameLevel = new GameLevel(new BackGround(GameConstResourceUtil.BG1), 20, 20);
        timers = new Timers(this);
        ui = new UI(this);

    }

    public Timers getTimers() {
        return timers;
    }

    public String getOperateWay() {
        return operateWay;
    }

    public void setOperateWay(String operateWay) {
        this.operateWay = operateWay;
    }

    public int getGlobalTime() {
        return globalTime;
    }

    public void setGlobalTime(int globalTime) {
        this.globalTime = globalTime;
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
