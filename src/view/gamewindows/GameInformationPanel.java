package view.gamewindows;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameInformationPanel extends JPanel {

    JLabel scoreLabel, lifeLabel, levelLabel, restEnemyPlaneQuantityLabel, passLineEnemyPlaneQuantityLabel, playerNameLabel;
    JLabel score, life, level, restEnemyPlaneQuantity, passLineEnemyPlaneQuantity, playerName;

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

        life = new JLabel("0");
        life.setBounds(150, 120, 120, 30);
        life.setFont(infoPaneFont);

        levelLabel = new JLabel("当前关卡：");
        levelLabel.setBounds(30, 170, 120, 30);
        levelLabel.setFont(infoPaneFont);

        level = new JLabel("0");
        level.setBounds(150, 170, 120, 30);
        level.setFont(infoPaneFont);

        restEnemyPlaneQuantityLabel = new JLabel("剩余敌人数：");
        restEnemyPlaneQuantityLabel.setBounds(10, 220, 150, 30);
        restEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        restEnemyPlaneQuantity = new JLabel("0");
        restEnemyPlaneQuantity.setBounds(150, 220, 120, 30);
        restEnemyPlaneQuantity.setFont(infoPaneFont);

        passLineEnemyPlaneQuantityLabel = new JLabel("逃出敌人数：");
        passLineEnemyPlaneQuantityLabel.setBounds(10, 270, 150, 30);
        passLineEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        passLineEnemyPlaneQuantity = new JLabel("0");
        passLineEnemyPlaneQuantity.setBounds(150, 270, 120, 30);
        passLineEnemyPlaneQuantity.setFont(infoPaneFont);

        playerNameLabel = new JLabel("当前玩家：");
        playerNameLabel.setBounds(30,320,150,30);
        playerNameLabel.setFont(infoPaneFont);

        playerName = new JLabel("null");
        playerName.setBounds(150,320,120,30);
        playerName.setFont(infoPaneFont);


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
        add(playerNameLabel);
        add(playerName);
    }
}
