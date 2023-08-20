package view.gamewindows;

import model.Game;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏界面主panel
 */
public class GameMainPanel extends JPanel {
    private final GamePanel gamePanel;
    private final GameInformationPanel gameInformationPanel;
    private final GameVicPanel gameVicPanel;

    public GameMainPanel(Game game) {
        setLayout(new BorderLayout());
        setBackground(Color.white);


        gamePanel = new GamePanel(game);
        gamePanel.setPreferredSize(new Dimension(800, 800));

        gameInformationPanel = new GameInformationPanel(game);
        gameInformationPanel.setPreferredSize(new Dimension(300, 800));

        gameVicPanel = new GameVicPanel(game);
        gameVicPanel.setPreferredSize(new Dimension(800, 800));


        add(gamePanel, BorderLayout.WEST);
        add(gameInformationPanel, BorderLayout.EAST);
    }

    public GameVicPanel getGameVicPanel() {
        return gameVicPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameInformationPanel getGameInformationPanel() {
        return gameInformationPanel;
    }
}
