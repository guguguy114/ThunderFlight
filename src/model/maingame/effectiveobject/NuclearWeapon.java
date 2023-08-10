package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameUIController;
import model.FlyingObject;
import model.Game;
import view.gamewindows.GameInformationPanel;
import view.gamewindows.GamePanel;

import java.util.Iterator;

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
        GameInformationPanel panel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        game.setNuclearNum(game.getNuclearNum() + 1);
        GameUIController.refreshInfoPanel(game);
    }

    public static void boom(Game game){
        if (game.getNuclearNum() >= 1){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
            if (iterator.hasNext()) {
                do {
                    FlyingObject temp = iterator.next();
                    if (temp.getObjectName().equals(GameConstStr.COMMON_ENEMY_PLANE_NAME)) {
                        temp.dead(game);
                    }
                } while (iterator.hasNext());
            }
            game.setNuclearNum(game.getNuclearNum() - 1);
        }else {
            System.out.println("fail_to_use_nuclear_weapon");
        }
    }
}
