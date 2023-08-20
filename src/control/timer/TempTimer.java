package control.timer;

import control.listener.TimerActionLis;
import model.Game;

import javax.swing.*;

public class TempTimer extends GameTimer{
    public TempTimer(Game game, String mode) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, mode);
        timer = new Timer(delay, timerActionLis);
    }
}
