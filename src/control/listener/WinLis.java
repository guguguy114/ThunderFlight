package control.listener;

import control.GameConstStr;
import control.GameController;
import control.GameUIController;
import model.Game;
import view.gamewindows.GameWin;
import view.loginwindows.LoginWin;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinLis implements WindowListener {
    private final Game game;
    private final String mode;

    public WinLis(Game game, String mode) {
        this.game = game;
        this.mode = mode;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        switch (mode) {
            case GameConstStr.PRIMARY_WIN:
                System.out.println(GameConstStr.PRIMARY_WIN);
                GameController.exit(game);
                break;
            case GameConstStr.SECONDARY_WIN:
                System.out.println(GameConstStr.SECONDARY_WIN);
                GameUIController.toGameWin(game);
                break;
            case GameConstStr.LIST_WIND:
                LoginWin loginWin = game.getUi().getLoginWin();
                GameWin gameWin = game.getUi().getGameWin();
                loginWin.setEnabled(true);
                gameWin.setEnabled(true);
                break;
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
