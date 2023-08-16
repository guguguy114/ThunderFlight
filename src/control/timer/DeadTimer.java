package control.timer;

import control.GameConstStr;
import control.listener.TimerActionLis;
import model.FlyingObject;
import model.Game;

import javax.swing.*;

public class DeadTimer extends GameTimer {
    /**
     * 死亡时用于触发爆炸动画
     * @param game 游戏对象
     * @param objIn 即将死亡的飞行物
     */
    public DeadTimer(Game game, FlyingObject objIn) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, objIn, GameConstStr.DEAD);
        timer = new Timer(delay, timerActionLis);
    }
}
