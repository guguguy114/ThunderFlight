package control.timer;

import control.listener.TimerActionLis;
import model.FlyingObject;
import model.Game;

import javax.swing.*;

/**
 * 敌机攻击频率所需的计时器
 */
public class AttackTimer extends GameTimer {
    /**
     *
     * @param game 游戏对象
     * @param flyingObject 定时器所在的飞行物对象
     * @param mode 特定目标的攻击模式：可选择：ENEMY,FRIEND,ENEMY_BOSS;
     */
    public AttackTimer(Game game, FlyingObject flyingObject, String mode) {
        super(game);
        TimerActionLis timerActionLis = new TimerActionLis(game, flyingObject, mode);
        timer = new Timer(delay, timerActionLis);
    }
}
