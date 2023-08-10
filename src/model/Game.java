package model;

import control.GameConstResourceUtil;
import control.timer.Timers;
import view.UI;

public class Game {
    private final UI ui;
    private final Timers timers;
    private Player player;
    private GameLevel gameLevel;
    private int gameMode;
    private String operateWay;
    private int globalTime;
    private int nuclearNum;
    public Game() {
        globalTime = 0;
        gameLevel = new GameLevel(new BackGround(GameConstResourceUtil.BG1), 20, 20, 1);
        timers = new Timers(this);
        ui = new UI(this);

    }

    public int getNuclearNum() {
        return nuclearNum;
    }

    public void setNuclearNum(int nuclearNum) {
        this.nuclearNum = nuclearNum;
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

    public void setPlayer(Player player) {
        this.player = player;
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
