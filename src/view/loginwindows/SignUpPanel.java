package view.loginwindows;

import control.GameConstStr;
import control.listener.ActionLis;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class SignUpPanel extends JPanel {
    JLabel accountLabel, passwordLabel, playerNameLabel, passwordConfirmLabel;
    JTextField accountPutIn, playerNamePutIn;
    JPasswordField passwordPutIn, passwordConfirmPutIn;
    JButton signUpBtn, returnBtn;
    public SignUpPanel(Game game){
        ActionLis actionLis = new ActionLis(game);
        setLayout(null);
        Font signUpPageFont = new Font("黑体", Font.BOLD, 20);


        playerNameLabel = new JLabel("输入名称");
        playerNameLabel.setBounds(260,240,100,40);
        playerNameLabel.setFont(signUpPageFont);

        playerNamePutIn = new JTextField();
        playerNamePutIn.setBounds(360,240,340,40);
        playerNamePutIn.setFont(signUpPageFont);

        accountLabel = new JLabel("账号");
        accountLabel.setBounds(300,300,60,40);
        accountLabel.setFont(signUpPageFont);

        accountPutIn = new JTextField();
        accountPutIn.setBounds(360,300,340,40);
        accountPutIn.setFont(signUpPageFont);

        passwordLabel = new JLabel("密码");
        passwordLabel.setBounds(300,360,60,40);
        passwordLabel.setFont(signUpPageFont);

        passwordPutIn = new JPasswordField();
        passwordPutIn.setEchoChar('*');
        passwordPutIn.setBounds(360,360,340,40);
        passwordPutIn.setFont(signUpPageFont);

        passwordConfirmLabel = new JLabel("确认密码");
        passwordConfirmLabel.setBounds(260,420,100,40);
        passwordConfirmLabel.setFont(signUpPageFont);

        passwordConfirmPutIn = new JPasswordField();
        passwordConfirmPutIn.setBounds(360, 420, 340, 40);
        passwordConfirmPutIn.setFont(signUpPageFont);

        signUpBtn = new JButton("注册");
        signUpBtn.setBounds(420, 500, 200,60);
        signUpBtn.setFont(signUpPageFont);
        signUpBtn.setActionCommand(GameConstStr.SIGNUP);
        signUpBtn.addActionListener(actionLis);

        returnBtn = new JButton("返回");
        returnBtn.setBounds(420,580,200,60);
        returnBtn.setFont(signUpPageFont);
        returnBtn.setActionCommand(GameConstStr.TO_LOGIN_PANE);
        returnBtn.addActionListener(actionLis);


        add(playerNameLabel);
        add(playerNamePutIn);
        add(accountLabel);
        add(accountPutIn);
        add(passwordLabel);
        add(passwordPutIn);
        add(passwordConfirmLabel);
        add(passwordConfirmPutIn);
        add(signUpBtn);
        add(returnBtn);
    }
}
