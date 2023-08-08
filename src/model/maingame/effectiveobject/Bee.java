package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import model.Game;

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
    public void changeAnimation() {

    }

    @Override
    public void hitFeedback() {

    }
}
