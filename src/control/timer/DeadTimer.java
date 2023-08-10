package control.timer;

import control.GameConstStr;
import control.listener.TimerActionLis;
import model.FlyingObject;
import model.Game;

import javax.swing.*;

public class DeadTimer extends GameTimer {
    public DeadTimer(Game game, FlyingObject objIn) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, objIn, GameConstStr.DEAD);
        timer = new Timer(delay, timerActionLis);
    }
}
