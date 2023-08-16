package model.maingame.enemy;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;

public class EnemyBoss extends EnemyPlane{


    public EnemyBoss(int x, int y, Game game) {
        super(GameConstResourceUtil.BOSS_1, x, y, game);
        attackTimer = new AttackTimer(game, this, GameConstStr.ENEMY);
        down = true;
        game.getGameLevel().setBossSummonCount(game.getGameLevel().getBossSummonCount() + 1);
    }

    @Override
    public void move(Game game) {

    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {

    }

    @Override
    public void hitFeedback(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    protected void setDeadImages() {

    }
}
