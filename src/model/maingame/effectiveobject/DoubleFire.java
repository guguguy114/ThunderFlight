package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameConstStr;
import model.Game;
import model.maingame.hero.HeroPlane;

public class DoubleFire extends EffectiveObject{


    public DoubleFire(Game game, int x, int y) {
        super(game, x, y);
        objImg = GameConstResourceUtil.DOUBLE_FIRE;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {

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
