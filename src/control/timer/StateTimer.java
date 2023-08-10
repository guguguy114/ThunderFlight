package control.timer;

import control.GameConstStr;
import control.listener.TimerActionLis;
import model.Game;
import model.maingame.hero.HeroPlane;

import javax.swing.*;

public class StateTimer extends GameTimer {
    public StateTimer(Game game, HeroPlane heroPlane) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, heroPlane, GameConstStr.HERO_STATE_LAST);
        timer = new Timer(delay, timerActionLis);
    }
}
