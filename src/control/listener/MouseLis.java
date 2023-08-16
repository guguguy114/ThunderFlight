package control.listener;

import control.GameConstDataUtil;
import control.GameConstStr;
import model.Game;
import view.gamewindows.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseLis implements MouseListener {
    private final Game game;

    public MouseLis(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("(" + e.getX() + "," + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (game.getOperateWay().equals(GameConstStr.MOUSE_CONTROL) && game.getGameMode() == GameConstDataUtil.RUNNING_MODE){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            gamePanel.getHeroPlane().isAtk = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getHeroPlane().isAtk = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
