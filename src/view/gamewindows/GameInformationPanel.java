package view.gamewindows;

import control.GameConstResourceUtil;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class GameInformationPanel extends JPanel {

    public JLabel scoreLabel, lifeLabel, levelLabel, restEnemyPlaneQuantityLabel, passLineEnemyPlaneQuantityLabel, playerNameLabel, nuclearNumLabel;
    public JLabel score, life, level, restEnemyPlaneQuantity, passLineEnemyPlaneQuantity, playerName, nuclearNum, commonNum, promoteNum, bossNum;

    GameInformationPanel(Game game){
        setLayout(null);
        Font infoPaneFont = new Font("黑体", Font.BOLD, 20);
        int basicY = 20;


        scoreLabel = new JLabel("得分：");
        scoreLabel.setBounds(73, basicY, 100, 30);
        scoreLabel.setFont(infoPaneFont);

        score = new JLabel("0");
        score.setBounds(150, basicY, 100, 30);
        score.setFont(infoPaneFont);

        lifeLabel = new JLabel("剩余生命值：");
        lifeLabel.setBounds(10, basicY + 50, 150, 30);
        lifeLabel.setFont(infoPaneFont);

        life = new JLabel();
        life.setBounds(150, basicY + 50, 120, 30);
        life.setFont(infoPaneFont);

        levelLabel = new JLabel("当前关卡：");
        levelLabel.setBounds(30, basicY + 50 * 2, 120, 30);
        levelLabel.setFont(infoPaneFont);

        level = new JLabel(String.valueOf(game.getGameLevel().getLevelName()));
        level.setBounds(150, basicY + 50 * 2, 120, 30);
        level.setFont(infoPaneFont);

        passLineEnemyPlaneQuantityLabel = new JLabel("逃出敌人数：");
        passLineEnemyPlaneQuantityLabel.setBounds(10, basicY + 50 * 3, 150, 30);
        passLineEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        passLineEnemyPlaneQuantity = new JLabel("0");
        passLineEnemyPlaneQuantity.setBounds(150, basicY + 50 * 3, 120, 30);
        passLineEnemyPlaneQuantity.setFont(infoPaneFont);

        nuclearNumLabel = new JLabel("拥有核弹数：");
        nuclearNumLabel.setBounds(10,basicY + 50 * 4,150,30);
        nuclearNumLabel.setFont(infoPaneFont);

        nuclearNum = new JLabel("0");
        nuclearNum.setBounds(150,basicY + 50 * 4,120,30);
        nuclearNum.setFont(infoPaneFont);

        playerNameLabel = new JLabel("当前玩家：");
        playerNameLabel.setBounds(30,basicY + 50 * 5,150,30);
        playerNameLabel.setFont(infoPaneFont);

        playerName = new JLabel();
        playerName.setBounds(150,basicY + 50 * 5,120,30);
        playerName.setFont(infoPaneFont);

        restEnemyPlaneQuantityLabel = new JLabel("剩余敌人数：");
        restEnemyPlaneQuantityLabel.setBounds(10, basicY + 50 * 6, 150, 30);
        restEnemyPlaneQuantityLabel.setFont(infoPaneFont);

        restEnemyPlaneQuantity = new JLabel();
        restEnemyPlaneQuantity.setBounds(150, basicY + 50 * 6, 120, 30);
        restEnemyPlaneQuantity.setFont(infoPaneFont);

        commonNum = new JLabel("0");
        commonNum.setBounds(35, basicY + 50 * 8, 100, 30);
        commonNum.setFont(infoPaneFont);

        promoteNum = new JLabel("0");
        promoteNum.setBounds(120, basicY + 50 * 8, 100, 30);
        promoteNum.setFont(infoPaneFont);

        bossNum = new JLabel("0");
        bossNum.setBounds(200, basicY + 50 * 8 + 25, 100, 30);
        bossNum.setFont(infoPaneFont);


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
        add(commonNum);
        add(promoteNum);
        add(bossNum);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(GameConstResourceUtil.COMMON_ENEMY_PLANE_1, 20, 360, 50, 50, null);
        g.drawImage(GameConstResourceUtil.PROMOTE_ENEMY_PLANE, 100, 360, 50, 50,null);
        g.drawImage(GameConstResourceUtil.BOSS_1, 180, 360, 56, 75,null);
    }
}
