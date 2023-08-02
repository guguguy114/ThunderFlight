package control;

import model.Game;
import view.infowindows.InfoMainPanel;
import view.loginwindows.LoginMainPanel;

public class GameUIController {

    public static void loginWinAndGameWinExchange(Game game, String mode){
        if (mode.equals(GameConstStr.TO_LOGIN_WIN)){
            System.out.println(GameConstStr.TO_LOGIN_WIN);
            game.getUi().getGameWin().setVisible(false);
            game.getUi().getLoginWin().setVisible(true);
        }else if (mode.equals(GameConstStr.TO_GAME_WIN)){
            System.out.println(GameConstStr.TO_GAME_WIN);
            game.getUi().getLoginWin().setVisible(false);
            game.getUi().getGameWin().setVisible(true);
        }
    }

    public static void aboutPaneAndHelpPaneExchange(Game game, String mode){
        if (mode.equals(GameConstStr.TO_ABOUT_PANE)){
            System.out.println(GameConstStr.TO_ABOUT_PANE);
            InfoMainPanel infoMainPanel = game.getUi().getInfoWin().getInfoMainPanel();
            infoMainPanel.removeAll();
            infoMainPanel.add(infoMainPanel.getAboutPanel());
            infoMainPanel.revalidate();
            game.getUi().getInfoWin().setTitle("关于");
            game.getUi().getGameWin().setEnabled(false);
            game.getUi().getInfoWin().setVisible(true);
        }else if (mode.equals(GameConstStr.TO_HELP_PANE)){
            System.out.println(GameConstStr.TO_HELP_PANE);
            InfoMainPanel infoMainPanel = game.getUi().getInfoWin().getInfoMainPanel();
            infoMainPanel.removeAll();
            infoMainPanel.add(infoMainPanel.getHelpPanel());
            infoMainPanel.revalidate();
            game.getUi().getInfoWin().setTitle("帮助");
            game.getUi().getGameWin().setEnabled(false);
            game.getUi().getInfoWin().setVisible(true);
        }
    }

    public static void signUpPaneAndLoginPaneExchange(Game game, String mode){
        if (mode.equals(GameConstStr.TO_SIGN_UP_PANE)){
            System.out.println(GameConstStr.TO_SIGN_UP_PANE);
            LoginMainPanel loginMainPanel = game.getUi().getLoginWin().getLoginMainPanel();
            loginMainPanel.removeAll();
            loginMainPanel.add(loginMainPanel.getSignUpPanel());
            loginMainPanel.repaint();
            loginMainPanel.revalidate();
            game.getUi().getLoginWin().setTitle("注册账号");
        }else if (mode.equals(GameConstStr.TO_LOGIN_PANE)){
            System.out.println(GameConstStr.TO_LOGIN_PANE);
            LoginMainPanel loginMainPanel = game.getUi().getLoginWin().getLoginMainPanel();
            loginMainPanel.removeAll();
            loginMainPanel.add(loginMainPanel.getLoginPanel());
            loginMainPanel.repaint();
            loginMainPanel.revalidate();
            game.getUi().getLoginWin().setTitle("登陆界面");
        }

    }

    public static void toGameWin(Game game){
        game.getUi().getGameWin().setEnabled(true);
    }

    public static void toCustomWin(Game game){
        game.getUi().getCustomWin().setVisible(true);
        game.getUi().getGameWin().setEnabled(false);
    }
}
