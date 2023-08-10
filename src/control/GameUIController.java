package control;

import model.Game;
import model.GameLevel;
import view.gamewindows.GameInformationPanel;
import view.gamewindows.GameMenuBar;
import view.gamewindows.GamePanel;
import view.infowindows.InfoMainPanel;
import view.loginwindows.LoginMainPanel;

public class GameUIController {

    public static void loginWinAndGameWinExchange(Game game, String mode) {
        if (mode.equals(GameConstStr.TO_LOGIN_WIN)) {
            System.out.println(GameConstStr.TO_LOGIN_WIN);
            game.getUi().getGameWin().setVisible(false);
            game.getUi().getLoginWin().setVisible(true);
        } else if (mode.equals(GameConstStr.TO_GAME_WIN)) {
            System.out.println(GameConstStr.TO_GAME_WIN);
            game.getUi().getLoginWin().setVisible(false);
            game.getUi().getGameWin().setVisible(true);
        }
    }

    public static void aboutPaneAndHelpPaneExchange(Game game, String mode) {
        if (mode.equals(GameConstStr.TO_ABOUT_PANE)) {
            System.out.println(GameConstStr.TO_ABOUT_PANE);
            InfoMainPanel infoMainPanel = game.getUi().getInfoWin().getInfoMainPanel();
            infoMainPanel.removeAll();
            infoMainPanel.add(infoMainPanel.getAboutPanel());
            infoMainPanel.revalidate();
            game.getUi().getInfoWin().setTitle("关于");
            game.getUi().getGameWin().setEnabled(false);
            game.getUi().getInfoWin().setVisible(true);
        } else if (mode.equals(GameConstStr.TO_HELP_PANE)) {
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

    public static void signUpPaneAndLoginPaneExchange(Game game, String mode) {
        if (mode.equals(GameConstStr.TO_SIGN_UP_PANE)) {
            System.out.println(GameConstStr.TO_SIGN_UP_PANE);
            LoginMainPanel loginMainPanel = game.getUi().getLoginWin().getLoginMainPanel();
            loginMainPanel.removeAll();
            loginMainPanel.add(loginMainPanel.getSignUpPanel());
            loginMainPanel.repaint();
            loginMainPanel.revalidate();
            game.getUi().getLoginWin().setTitle("注册账号");
        } else if (mode.equals(GameConstStr.TO_LOGIN_PANE)) {
            System.out.println(GameConstStr.TO_LOGIN_PANE);
            LoginMainPanel loginMainPanel = game.getUi().getLoginWin().getLoginMainPanel();
            loginMainPanel.removeAll();
            loginMainPanel.add(loginMainPanel.getLoginPanel());
            loginMainPanel.repaint();
            loginMainPanel.revalidate();
            game.getUi().getLoginWin().setTitle("登陆界面");
        }

    }

    public static void toGameWin(Game game) {
        game.getUi().getGameWin().setEnabled(true);
        game.getUi().getInfoWin().setVisible(false);
    }

    public static void toCustomWin(Game game) {
        game.getUi().getCustomWin().setVisible(true);
        game.getUi().getGameWin().setEnabled(false);
    }

    public static void changeMenu(Game game, int mode) {
        switch (mode) {
            case GameConstDataUtil.READY_MODE:
                GameMenuBar menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(false);
                menuBar.continueGame.setEnabled(false);
                menuBar.customMode.setEnabled(true);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(true);
                menuBar.restartGame.setEnabled(false);
                break;
            case GameConstDataUtil.RUNNING_MODE:
                menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(true);
                menuBar.continueGame.setEnabled(false);
                menuBar.customMode.setEnabled(false);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(false);
                menuBar.restartGame.setEnabled(false);
                break;
            case GameConstDataUtil.PAUSE_MODE:
                menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(false);
                menuBar.continueGame.setEnabled(true);
                menuBar.customMode.setEnabled(false);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(false);
                menuBar.restartGame.setEnabled(true);
        }
    }

    public static void refreshInfoPanel(Game game) {
        GameInformationPanel panel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        panel.nuclearNum.setText(String.valueOf(game.getNuclearNum()));
        panel.score.setText(String.valueOf(game.getPlayer().getScore()));
        panel.playerName.setText(game.getPlayer().getPlayerName());
        panel.life.setText(String.valueOf(gamePanel.getHeroPlane().getLife()));
        GameLevel gameLevel = game.getGameLevel();
        panel.restEnemyPlaneQuantity.setText(String.valueOf(gameLevel.getCommonEnemyPlaneQuantity() + gameLevel.getPromotedEnemyPlaneQuantity() - gameLevel.getCommonCount() - gameLevel.getPromoteCount()));
        panel.commonNum.setText(String.valueOf(gameLevel.getCommonEnemyPlaneQuantity() - gameLevel.getCommonCount()));
    }
}
