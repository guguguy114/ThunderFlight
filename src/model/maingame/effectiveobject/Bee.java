package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import model.Game;
import model.Music;
import model.maingame.hero.HeroPlane;

public class Bee extends EffectiveObject{

    public Bee(Game game, int x, int y) {
        super(game, x, y);
        img = GameConstResourceUtil.BEE;
        width = img.getWidth(null);
        height = img.getHeight(null);
        hitMusic = new Music(Music.ADD_LIFE);
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
        heroPlane.setLife(heroPlane.getLife() + 1);
    }
}
