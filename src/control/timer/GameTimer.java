package control.timer;

import model.Game;

import javax.swing.*;

/**
 * 计时器总类
 */
public abstract class GameTimer {
    protected Timer timer;
    protected Game game;
    protected int delay = 1;

    public GameTimer(Game game) {
        this.game = game;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
