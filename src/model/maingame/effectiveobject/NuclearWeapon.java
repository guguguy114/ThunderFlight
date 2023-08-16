package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameUIController;
import model.BigBomb;
import model.FlyingObject;
import model.Game;
import view.gamewindows.GameInformationPanel;
import view.gamewindows.GamePanel;

import java.util.Iterator;

public class NuclearWeapon extends EffectiveObject{


    public NuclearWeapon(Game game, int x, int y) {
        super(game, x, y);
        img = GameConstResourceUtil.NUCLEAR_BOMB;
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
        GameInformationPanel panel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        game.setNuclearNum(game.getNuclearNum() + 1);
        GameUIController.refreshInfoPanel(game);
    }

    public static void boom(Game game){
        if (game.getNuclearNum() >= 1){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            BigBomb bomb = new BigBomb(game);
            gamePanel.getPlaneList().add(bomb);
            Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
            if (iterator.hasNext()) {
                do {
                    FlyingObject temp = iterator.next();
                    if (temp.getClassName().equals(GameConstStr.ENEMY_PLANE_NAME)) {
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
