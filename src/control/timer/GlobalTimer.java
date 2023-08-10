package control.timer;

import control.GameConstStr;
import control.listener.TimerActionLis;
import model.Game;

import javax.swing.*;

public class GlobalTimer extends GameTimer {
    public GlobalTimer(Game game) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, GameConstStr.GLOBAL);
        timer = new Timer(delay, timerActionLis);
    }
}
