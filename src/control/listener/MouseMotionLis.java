package control.listener;

import control.GameConstDataUtil;
import control.GameConstStr;
import model.Game;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionLis implements MouseMotionListener {
    private final Game game;

    public MouseMotionLis(Game game) {
        this.game = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        posUpgrade(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posUpgrade(e);
    }

    private void posUpgrade(MouseEvent e) {
        if (game.getOperateWay().equals(GameConstStr.MOUSE_CONTROL) && game.getGameMode() == GameConstDataUtil.RUNNING_MODE) {
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            HeroPlane heroPlane = gamePanel.getHeroPlane();
            heroPlane.setObjX(e.getX() - heroPlane.getWidth() / 2);
            heroPlane.setObjY(e.getY() - heroPlane.getHeight() / 4 * 3);
        }
    }
}
