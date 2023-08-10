package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import model.Game;
import model.maingame.hero.HeroPlane;

public class Bee extends EffectiveObject{

    public Bee(Game game, int x, int y) {
        super(game, x, y);
        objImg = GameConstResourceUtil.BEE;
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
        heroPlane.setLife(heroPlane.getLife() + 1);
    }
}
