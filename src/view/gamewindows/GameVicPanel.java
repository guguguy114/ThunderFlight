package view.gamewindows;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.TempTimer;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameVicPanel extends JPanel {

    public JLabel countLabel, count;
    private TempTimer TempTimer;
    private Image screen;

    GameVicPanel(Game game) {
        setLayout(null);
        Font endFont = new Font("黑体", Font.BOLD, 30);

        countLabel = new JLabel("关卡通过！  秒后将进入下一关");
        countLabel.setBounds(200, 400, 700, 50);
        countLabel.setFont(endFont);

        count = new JLabel(String.valueOf(GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK));
        count.setBounds(350, 400, 200, 50);
        count.setFont(endFont);

        add(countLabel);
        add(count);
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(screen, 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, (screen.getHeight(null) - screen.getWidth(null)) / 2, screen.getWidth(null), (screen.getHeight(null) + screen.getWidth(null)) / 2, null);
    }

    public void readyToNextLevel(Game game) {
        screen = GameConstResourceUtil.PASS_SCREEN;
        TempTimer = new TempTimer(game, GameConstStr.READY_TO_NEXT_LEVEL);
        TempTimer.getTimer().start();
    }

    public void readyToRestartLevel(Game game){
        screen = GameConstResourceUtil.OVER_SCREEN;
        TempTimer = new TempTimer(game, GameConstStr.READY_TO_RESTART_LEVEL);
        TempTimer.getTimer().start();
    }












    public TempTimer getTempTimer() {
        return TempTimer;
    }
}
