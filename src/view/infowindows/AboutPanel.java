package view.infowindows;

import control.GameConstStr;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {
    JLabel msg, gameVersionLabel, gameVersion;

    public AboutPanel(Game game){
        setLayout(null);
        Font aboutFont = new Font("黑体", Font.BOLD, 20);

        msg = new JLabel("雷霆战机游戏 作者：guguguy");
        msg.setBounds(70,100,300,20);
        msg.setFont(aboutFont);

        gameVersionLabel = new JLabel("Version:");
        gameVersionLabel.setBounds(140,160,100,20);
        gameVersionLabel.setFont(aboutFont);

        gameVersion = new JLabel(GameConstStr.VERSION);
        gameVersion.setBounds(240,160,100,20);
        gameVersion.setFont(aboutFont);


        add(msg);
        add(gameVersionLabel);
        add(gameVersion);
    }
}
