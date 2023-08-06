package control.timer;

import control.listener.TimerActionLis;
import model.FlyingObject;
import model.Game;

import javax.swing.*;

public class AttackTimer extends GameTimer{
    public AttackTimer(Game game, FlyingObject flyingObject) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, flyingObject);
        timer = new Timer(delay, timerActionLis);
    }
}
