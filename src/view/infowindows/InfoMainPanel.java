package view.infowindows;

import model.Game;

import javax.swing.*;

public class InfoMainPanel extends JPanel {
    private final AboutPanel aboutPanel;
    private final HelpPanel helpPanel;

    public InfoMainPanel(Game game) {
        setLayout(null);


        aboutPanel = new AboutPanel(game);
        aboutPanel.setBounds(0,0,400,400);

        helpPanel = new HelpPanel(game);
        helpPanel.setBounds(0, 0, 400, 400);


        add(helpPanel);
    }

    public AboutPanel getAboutPanel() {
        return aboutPanel;
    }

    public HelpPanel getHelpPanel() {
        return helpPanel;
    }
}
