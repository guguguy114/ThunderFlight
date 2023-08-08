package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import model.Game;

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
    public void changeAnimation() {

    }

    @Override
    public void hitFeedback() {

    }
}
