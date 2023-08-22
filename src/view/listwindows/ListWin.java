package view.listwindows;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class ListWin extends JFrame {
    ListPanel listPanel;
    public ListWin(Game game){
        setResizable(false);
        setFocusable(true);
        setSize(500, 500);
        setTitle("登录界面");
        setLocationRelativeTo(null);
        setIconImage(GameConstResourceUtil.HERO_UP);
        WinLis winLis = new WinLis(game, GameConstStr.LIST_WIND);

        listPanel = new ListPanel();


        add(listPanel);


        addWindowListener(winLis);
        setVisible(false);
    }

    public ListPanel getListPanel() {
        return listPanel;
    }
}
