package view.gamewindows;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameMainPanel extends JPanel {
    private final GamePanel gamePanel;
    private final GameInformationPanel gameInformationPanel;

    public GameMainPanel(Game game) {
        setLayout(new BorderLayout());



        gamePanel = new GamePanel(game);
        gamePanel.setPreferredSize(new Dimension(800, 800));

        gameInformationPanel = new GameInformationPanel(game);
        gameInformationPanel.setBackground(Color.white);
        gameInformationPanel.setPreferredSize(new Dimension(200, 1000));


        add(gamePanel, BorderLayout.WEST);
        add(gameInformationPanel, BorderLayout.EAST);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameInformationPanel getGameInformationPanel() {
        return gameInformationPanel;
    }
}
