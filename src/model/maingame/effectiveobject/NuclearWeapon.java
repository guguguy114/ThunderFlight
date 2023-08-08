package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameUIController;
import model.Game;
import view.gamewindows.GameInformationPanel;

public class NuclearWeapon extends EffectiveObject{


    public NuclearWeapon(Game game, int x, int y) {
        super(game, x, y);
        objImg = GameConstResourceUtil.NUCLEAR_BOMB;
        objectWidth = objImg.getWidth(null);
        objectHeight = objImg.getHeight(null);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("nuclear_moving");
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    public void hitFeedback() {
        GameInformationPanel panel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        game.setNuclearNum(game.getNuclearNum() + 1);
        GameUIController.refreshInfoPanel(game);
    }
}
