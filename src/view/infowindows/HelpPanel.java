package view.infowindows;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class HelpPanel extends JPanel {

    JLabel info, message;
    JButton keyOpt, msOpt;

    public HelpPanel(Game game){
        setLayout(null);
        Font helpPageFont = new Font("黑体", Font.BOLD, 30);
        Font msgFont = new Font("黑体", Font.BOLD, 25);


        info = new JLabel("！欢迎来到雷霆战机！");
        info.setBounds(40,30,400,30);
        info.setFont(helpPageFont);

        message = new JLabel("请选择您的操作模式");
        message.setBounds(80,100,400,25);
        message.setFont(msgFont);

        keyOpt = new JButton("键盘操作");
        keyOpt.setBounds(60, 180, 140, 40);
        keyOpt.setFont(msgFont);

        msOpt = new JButton("鼠标操作");
        msOpt.setBounds(220,180,140,40);
        msOpt.setFont(msgFont);


        add(info);
        add(message);
        add(keyOpt);
        add(msOpt);
    }
}
