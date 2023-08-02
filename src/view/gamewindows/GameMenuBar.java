package view.gamewindows;

import control.GameConstStr;
import control.listener.ActionLis;
import model.Game;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {
    JMenu gameStateMenu, otherMenu;
    JMenuItem startGame, pauseGame, exitGame, continueGame, customMode, about, help;

    public GameMenuBar(Game game){
        ActionLis actionLis = new ActionLis(game);

        gameStateMenu = new JMenu("游戏");

        startGame = new JMenuItem("新游戏");
        startGame.setActionCommand(GameConstStr.START);
        startGame.addActionListener(actionLis);

        pauseGame = new JMenuItem("暂停游戏");
        pauseGame.setActionCommand(GameConstStr.PAUSE);
        pauseGame.addActionListener(actionLis);

        exitGame = new JMenuItem("退出游戏");
        exitGame.setActionCommand(GameConstStr.EXIT);
        exitGame.addActionListener(actionLis);

        continueGame = new JMenuItem("继续游戏");
        continueGame.setActionCommand(GameConstStr.CONTINUE);
        continueGame.addActionListener(actionLis);

        customMode = new JMenuItem("自定义游戏");
        customMode.setActionCommand(GameConstStr.TO_CUSTOM_WIN);
        customMode.addActionListener(actionLis);

        gameStateMenu.add(startGame);
        gameStateMenu.add(pauseGame);
        gameStateMenu.add(exitGame);
        gameStateMenu.add(continueGame);
        gameStateMenu.add(customMode);

        otherMenu = new JMenu("其他");

        about = new JMenuItem("关于");
        about.setActionCommand(GameConstStr.TO_ABOUT_PANE);
        about.addActionListener(actionLis);

        help = new JMenuItem("帮助");
        help.setActionCommand(GameConstStr.TO_HELP_PANE);
        help.addActionListener(actionLis);

        otherMenu.add(about);
        otherMenu.add(help);


        add(gameStateMenu);
        add(otherMenu);
    }
}
