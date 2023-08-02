package model;

import control.timer.GlobalTimer;
import view.UI;

public class Game {
    private final UI ui;
    private Player player;
    private GameLevel gameLevel;
    private int gameMode;
    private GlobalTimer globalTimer;
    private String operateWay;

    public Game() {
        ui = new UI(this);
    }

    public void setOperateWay(String operateWay) {
        this.operateWay = operateWay;
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
