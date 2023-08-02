package view.gamewindows;

import control.GameConstStr;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class GameWin extends JFrame {
    private GameMainPanel gameMainPanel;
    private GameMenuBar gameMenuBar;

    public GameWin(Game game){
        setResizable(false);
        setSize(1000,860);
        setTitle("雷霆战机");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WinLis(game, GameConstStr.PRIMARY_WIN));

        gameMainPanel = new GameMainPanel(game);
        gameMenuBar = new GameMenuBar(game);

        add(gameMainPanel);
        setJMenuBar(gameMenuBar);

        setVisible(false);
    }
}
