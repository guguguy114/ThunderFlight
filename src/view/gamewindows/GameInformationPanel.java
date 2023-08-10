package view.gamewindows;

import control.GameConstResourceUtil;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameInformationPanel extends JPanel {

    public JLabel scoreLabel, lifeLabel, levelLabel, restEnemyPlaneQuantityLabel, passLineEnemyPlaneQuantityLabel, playerNameLabel, timeLabel, nuclearNumLabel;
    public JLabel score, life, level, restEnemyPlaneQuantity, passLineEnemyPlaneQuantity, playerName, time, nuclearNum, commonNum, promoteNum, bossNum;

    GameInformationPanel(Game game){
        setLayout(null);
        Font infoPaneFont = new Font("黑体", Font.BOLD, 20);


        scoreLabel = new JLabel("得分：");
        scoreLabel.setBounds(73, 70, 100, 30);
        scoreLabel.setFont(infoPaneFont);

        score = new JLabel("0");
        score.setBounds(150, 70, 100, 30);
        score.setFont(infoPaneFont);

        lifeLabel = new JLabel("剩余生命值：");
        lifeLabel.setBounds(10, 120, 150, 30);
        lifeLabel.setFont(infoPaneFont);

        life = new JLabel();
        life.setBounds(150, 120, 120, 30);
        life.setFont(infoPaneFont);

        levelLabel = new JLabel("当前关卡：");
        levelLabel.setBounds(30, 170, 120, 30);
        levelLabel.setFont(infoPaneFont);

        level = new JLabel(String.valueOf(game.getGameLevel().getLevel()));
        level.setBounds(150, 170, 120, 30);
        level.setFont(infoPaneFont);

        passLineEnemyPlaneQuantityLabel = new JLabel("逃出敌人数：");
        passLineEnemyPlaneQuantityLabel.setBounds(10, 220, 150, 30);
        passLineEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        passLineEnemyPlaneQuantity = new JLabel("0");
        passLineEnemyPlaneQuantity.setBounds(150, 220, 120, 30);
        passLineEnemyPlaneQuantity.setFont(infoPaneFont);

        nuclearNumLabel = new JLabel("拥有核弹数：");
        nuclearNumLabel.setBounds(10,270,150,30);
        nuclearNumLabel.setFont(infoPaneFont);

        nuclearNum = new JLabel(String.valueOf(game.getNuclearNum()));
        nuclearNum.setBounds(150,270,120,30);
        nuclearNum.setFont(infoPaneFont);

        playerNameLabel = new JLabel("当前玩家：");
        playerNameLabel.setBounds(30,320,150,30);
        playerNameLabel.setFont(infoPaneFont);

        playerName = new JLabel();
        playerName.setBounds(150,320,120,30);
        playerName.setFont(infoPaneFont);

        timeLabel = new JLabel("时间：");
        timeLabel.setBounds(72, 370, 100, 30);
        timeLabel.setFont(infoPaneFont);

        time = new JLabel();
        time.setBounds(150, 370, 100, 30);
        time.setFont(infoPaneFont);

        restEnemyPlaneQuantityLabel = new JLabel("剩余敌人数：");
        restEnemyPlaneQuantityLabel.setBounds(10, 420, 150, 30);
        restEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        restEnemyPlaneQuantity = new JLabel();
        restEnemyPlaneQuantity.setBounds(150, 420, 120, 30);
        restEnemyPlaneQuantity.setFont(infoPaneFont);

        commonNum = new JLabel("0");
        commonNum.setBounds(50, 570, 100, 30);
        commonNum.setFont(infoPaneFont);


        add(scoreLabel);
        add(score);
        add(lifeLabel);
        add(life);
        add(levelLabel);
        add(level);
        add(restEnemyPlaneQuantityLabel);
        add(restEnemyPlaneQuantity);
        add(passLineEnemyPlaneQuantityLabel);
        add(passLineEnemyPlaneQuantity);
        add(nuclearNumLabel);
        add(nuclearNum);
        add(playerNameLabel);
        add(playerName);
        add(timeLabel);
        add(time);
        add(commonNum);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(GameConstResourceUtil.COMMON_ENEMY_PLANE_1, 40, 500, 50, 50, null);
    }
}
