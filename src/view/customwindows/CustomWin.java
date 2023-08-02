package view.customwindows;

import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class CustomWin extends JFrame {
    private CustomPanel customPanel;

    public CustomWin(Game game){
        setResizable(false);
        setSize(1000, 400);
        setTitle("自定义");
        setLocationRelativeTo(null);
        addWindowListener(new WinLis(game, GameConstStr.SECONDARY_WIN));


        customPanel = new CustomPanel(game);


        add(customPanel);


        setVisible(false);
    }
}
