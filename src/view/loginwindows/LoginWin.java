package view.loginwindows;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.listener.KeyLis;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class LoginWin extends JFrame {
    private final LoginMainPanel loginMainPanel;

    public LoginWin(Game game) {
        setResizable(false);
        setFocusable(true);
        KeyLis keyLis = new KeyLis(game,GameConstStr.LOGIN);
        setSize(1000, 860);
        setTitle("登录界面");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WinLis(game, GameConstStr.PRIMARY_WIN));
        setIconImage(GameConstResourceUtil.HERO_UP);

        loginMainPanel = new LoginMainPanel(game);

        add(loginMainPanel);
        addKeyListener(keyLis);

        setVisible(true);
    }

    public LoginMainPanel getLoginMainPanel() {
        return loginMainPanel;
    }
}
