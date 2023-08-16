package control.timer;

import control.listener.TimerActionLis;
import model.FlyingObject;
import model.Game;

import javax.swing.*;

/**
 * 敌机攻击频率所需的计时器
 */
public class AttackTimer extends GameTimer {
    public AttackTimer(Game game, FlyingObject flyingObject, String mode) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, flyingObject, mode);
        timer = new Timer(delay, timerActionLis);
    }
}
