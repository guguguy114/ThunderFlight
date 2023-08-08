package view.infowindows;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class InfoWin extends JFrame {
    private final InfoMainPanel infoMainPanel;

    public InfoWin(Game game) {
        setResizable(false);
        setSize(400, 400);
        setTitle("帮助");
        setLocationRelativeTo(null);
        addWindowListener(new WinLis(game, GameConstStr.SECONDARY_WIN));
        setIconImage(GameConstResourceUtil.HERO_UP);


        infoMainPanel = new InfoMainPanel(game);


        add(infoMainPanel);


        setVisible(false);
    }

    public InfoMainPanel getInfoMainPanel() {
        return infoMainPanel;
    }
}
