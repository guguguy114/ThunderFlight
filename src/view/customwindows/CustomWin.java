package view.customwindows;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

/**
 * 自定义窗口
 */
public class CustomWin extends JFrame {
    private final CustomPanel customPanel;

    public CustomWin(Game game) {
        setResizable(false);
        setSize(600, 400);
        setTitle("自定义");
        setLocationRelativeTo(null);
        addWindowListener(new WinLis(game, GameConstStr.SECONDARY_WIN));
        setIconImage(GameConstResourceUtil.HERO_UP);


        customPanel = new CustomPanel(game);


        add(customPanel);


        setVisible(false);
    }

    public CustomPanel getCustomPanel() {
        return customPanel;
    }
}
