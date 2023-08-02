package view.loginwindows;

import model.Game;

import javax.swing.*;

public class LoginMainPanel extends JPanel {
    private final SignUpPanel signUpPanel;
    private final LoginPanel loginPanel;

    public LoginMainPanel(Game game) {
        setLayout(null);

        loginPanel = new LoginPanel(game);
        loginPanel.setBounds(0, 0, 1000, 800);

        signUpPanel = new SignUpPanel(game);
        signUpPanel.setBounds(0, 0, 1000, 800);

        add(loginPanel);
    }

    public SignUpPanel getSignUpPanel() {
        return signUpPanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
}
