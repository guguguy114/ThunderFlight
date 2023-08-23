package view.loginwindows;

import control.GameConstDataUtil;
import control.GameConstStr;
import control.GameController;
import control.listener.ActionLis;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public JLabel accountLabel, title, passwordLabel, YZMLabel, YZM;
    public JTextField accountPutIn, YZMPutIn;
    JButton loginBtn, signUpBtn, YZMRefreshBtn, exitBtn, listBtn;
    public JPasswordField passwordPutIn;
    Box labelBox, putInBox;
    LoginPanel(Game game){
        setLayout(null);
        ActionLis actionLis = new ActionLis(game);
        //Box centerBox = Box.createVerticalBox();
        Font loginPageFont = new Font("黑体", Font.BOLD, 20);
        Font titleFont = new Font("黑体", Font.BOLD, 40);
        //setLayout(new BorderLayout());



        System.out.println("creating_login_pane");


        title = new JLabel("登陆界面");
        title.setBounds(440,100,200,80);
        title.setFont(titleFont);

        accountLabel = new JLabel("账号");
        accountLabel.setBounds(300,300,60,40);
        accountLabel.setFont(loginPageFont);

        accountPutIn = new JTextField();
        accountPutIn.setBounds(360,300,340,40);
        accountPutIn.setFont(loginPageFont);

        passwordLabel = new JLabel("密码");
        passwordLabel.setBounds(300,360,60,40);
        passwordLabel.setFont(loginPageFont);

        passwordPutIn = new JPasswordField();
        passwordPutIn.setEchoChar('*');
        passwordPutIn.setBounds(360,360,340,40);
        passwordPutIn.setFont(loginPageFont);

        YZMLabel = new JLabel("验证码");
        YZMLabel.setBounds(280,420,70,40);
        YZMLabel.setFont(loginPageFont);

        YZMPutIn = new JTextField();
        YZMPutIn.setBounds(360,420,100,40);
        YZMPutIn.setFont(loginPageFont);

        YZM = new JLabel(GameController.code());
        YZM.setBounds(480,420,100,40);
        YZM.setFont(loginPageFont);

        YZMRefreshBtn = new JButton("刷新验证码");
        YZMRefreshBtn.setBounds(540,420,160,40);
        YZMRefreshBtn.setFont(loginPageFont);
        YZMRefreshBtn.setActionCommand(GameConstStr.REFRESH_YZM);
        YZMRefreshBtn.addActionListener(actionLis);

        loginBtn = new JButton("登录");
        loginBtn.setBounds(420, 500, 200,60);
        loginBtn.setFont(loginPageFont);
        loginBtn.setActionCommand(GameConstStr.LOGIN);
        loginBtn.addActionListener(actionLis);

        signUpBtn = new JButton("注册");
        signUpBtn.setBounds(420,580,200,60);
        signUpBtn.setFont(loginPageFont);
        signUpBtn.setActionCommand(GameConstStr.TO_SIGN_UP_PANE);
        signUpBtn.addActionListener(actionLis);

        exitBtn = new JButton("退出游戏");
        exitBtn.setBounds(420,660,200,60);
        exitBtn.setFont(loginPageFont);
        exitBtn.setActionCommand(GameConstStr.EXIT);
        exitBtn.addActionListener(actionLis);

        listBtn = new JButton("排行榜");
        listBtn.setBounds(420,740, 200, 60);
        listBtn.setFont(loginPageFont);
        listBtn.setActionCommand(GameConstStr.LIST);
        actionLis = new ActionLis(game, GameConstDataUtil.LOGIN_MODE);
        listBtn.addActionListener(actionLis);




        /*
        add(title, BorderLayout.NORTH);
        add(accountLabel, BorderLayout.CENTER);
        */
        add(title);
        add(accountLabel);
        add(accountPutIn);
        add(passwordLabel);
        add(passwordPutIn);
        add(YZMLabel);
        add(YZMPutIn);
        add(YZM);
        add(YZMRefreshBtn);
        add(loginBtn);
        add(signUpBtn);
        add(exitBtn);
        add(listBtn);
    }
}
