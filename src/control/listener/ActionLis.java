package control.listener;

import control.GameController;
import control.GameUIController;
import model.Game;
import control.GameConstStr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionLis implements ActionListener {
    private final Game game;

    public ActionLis(Game game){
        this.game = game;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case GameConstStr.LOGIN:
                GameController.login(game);
                break;
            case GameConstStr.TO_SIGN_UP_PANE:
                GameUIController.signUpPaneAndLoginPaneExchange(game, GameConstStr.TO_SIGN_UP_PANE);
                break;
            case GameConstStr.EXIT:
                GameController.exit(game);
                break;
            case GameConstStr.TO_ABOUT_PANE:
                GameUIController.aboutPaneAndHelpPaneExchange(game, GameConstStr.TO_ABOUT_PANE);
                break;
            case GameConstStr.TO_HELP_PANE:
                GameUIController.aboutPaneAndHelpPaneExchange(game, GameConstStr.TO_HELP_PANE);
                break;
            case GameConstStr.TO_CUSTOM_WIN:
                GameUIController.toCustomWin(game);
                break;
            case GameConstStr.TO_LOGIN_PANE:
                GameUIController.signUpPaneAndLoginPaneExchange(game, GameConstStr.TO_LOGIN_PANE);
                break;
            case GameConstStr.PAUSE:
                GameController.pause(game);
                break;
            case GameConstStr.CONTINUE:
                GameController.continueGame(game);
                break;
            case GameConstStr.KEYBOARD_CONTROL:
                GameController.setKeyOpt(game);
                break;
            case GameConstStr.MOUSE_CONTROL:
                GameController.setMouseOpt(game);
                break;
            case GameConstStr.START:
                GameController.start(game);
                break;
        }
    }
}
