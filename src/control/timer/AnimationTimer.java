package control.timer;

import control.GameConstStr;
import control.listener.TimerActionLis;
import model.Game;

import javax.swing.*;

public class AnimationTimer extends GameTimer{
    public AnimationTimer(Game game) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, GameConstStr.ANIMATION);
        timer = new Timer(delay, timerActionLis);
    }
}
