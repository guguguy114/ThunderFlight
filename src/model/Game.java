package model;

import control.timer.Timers;
import view.UI;

public class Game {

    // 玩家  背景 英雄 几个列表 定时任务 和定时器 Timer
    private final UI ui;
    private final Timers timers;
    private Player player;
    private GameLevel gameLevel;
    private int gameMode;
    private String operateWay;




    public Game() {
        JDBCUtil jdbcUtil = new JDBCUtil();
        gameLevel = jdbcUtil.loadLevel(1);
        timers = new Timers(this);
        ui = new UI(this);
        operateWay = "0";
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
