package control.listener;

import control.GameConstStr;
import control.GameController;
import control.GameUIController;
import model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionLis implements ActionListener {
    private final Game game;
    private final int mode;

    public ActionLis(Game game) {
        this.game = game;
        mode = -1;
    }

    public ActionLis(Game game, int mode){
        this.game = game;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case GameConstStr.LOGIN:
                GameController.login(game);
                break;
            case GameConstStr.TO_SIGN_UP_PANE:
                GameUIController.signUpPaneAndLoginPaneExchange(game, GameConstStr.TO_SIGN_UP_PANE);
                break;
            case GameConstStr.SIGNUP:
                GameController.signUp(game);
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
            case GameConstStr.RESTART:
                GameController.restartJudge(game, GameConstStr.COMMON);
                break;
            case GameConstStr.LEVEL_CONFIRM:
                GameController.levelChange(game, GameConstStr.CUSTOM_MODE);
                break;
            case GameConstStr.LIST:
                GameController.toList(game, mode);
                break;
        }
    }
}
