package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameConstStr;
import model.Game;
import model.maingame.hero.HeroPlane;

public class DoubleFire extends EffectiveObject{


    public DoubleFire(Game game, int x, int y) {
        super(game, x, y);
        img = GameConstResourceUtil.DOUBLE_FIRE;
        width = img.getWidth(null);
        height = img.getHeight(null);
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    protected void setDeadImages() {

    }

    @Override
    public void hitFeedback() {
        HeroPlane heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        heroPlane.atkMode = GameConstStr.DOUBLE_ATK_MODE;
        heroPlane.stateTimer.getTimer().restart();
    }
}
