package view.loginwindows;

import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class LoginWin extends JFrame {
    private final LoginMainPanel loginMainPanel;

    public LoginWin(Game game) {
        setResizable(false);
        setSize(1000, 860);
        setTitle("登录界面");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WinLis(game, GameConstStr.PRIMARY_WIN));

        loginMainPanel = new LoginMainPanel(game);

        add(loginMainPanel);

        setVisible(true);
    }

    public LoginMainPanel getLoginMainPanel() {
        return loginMainPanel;
    }
}
