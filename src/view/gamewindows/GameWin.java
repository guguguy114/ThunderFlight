package view.gamewindows;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.listener.KeyLis;
import control.listener.MouseLis;
import control.listener.MouseMotionLis;
import control.listener.WinLis;
import model.Game;

import javax.swing.*;

public class GameWin extends JFrame {
    private final GameMainPanel gameMainPanel;
    private final GameMenuBar gameMenuBar;

    public GameWin(Game game) {
        setFocusable(true);
        addKeyListener(new KeyLis(game, GameConstStr.MAIN_GAME));
        addMouseListener(new MouseLis(game));
        addMouseMotionListener(new MouseMotionLis(game));
        setResizable(false);
        setSize(1100, 860);
        setTitle("雷霆战机");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WinLis(game, GameConstStr.PRIMARY_WIN));
        setIconImage(GameConstResourceUtil.HERO_UP);

        gameMainPanel = new GameMainPanel(game);
        gameMenuBar = new GameMenuBar(game);

        add(gameMainPanel);
        setJMenuBar(gameMenuBar);

        setVisible(false);
    }

    public GameMainPanel getGameMainPanel() {
        return gameMainPanel;
    }

    public GameMenuBar getGameMenuBar() {
        return gameMenuBar;
    }

}
