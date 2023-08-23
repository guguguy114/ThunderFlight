package control;

import model.Game;
import model.GameLevel;
import model.JDBCUtil;
import model.Player;
import view.gamewindows.*;
import view.infowindows.HelpPanel;
import view.infowindows.InfoMainPanel;
import view.listwindows.ListPanel;
import view.listwindows.ListWin;
import view.loginwindows.LoginMainPanel;
import view.loginwindows.LoginPanel;
import view.loginwindows.LoginWin;

import java.awt.*;

/**
 * ui总控，用于操作全部界面切换功能
 */
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
            GameController.pause(game);
        } else if (mode.equals(GameConstStr.TO_HELP_PANE)) {
            System.out.println(GameConstStr.TO_HELP_PANE);
            InfoMainPanel infoMainPanel = game.getUi().getInfoWin().getInfoMainPanel();
            infoMainPanel.removeAll();
            infoMainPanel.add(infoMainPanel.getHelpPanel());
            infoMainPanel.revalidate();
            game.getUi().getInfoWin().setTitle("帮助");
            game.getUi().getGameWin().setEnabled(false);
            game.getUi().getInfoWin().setVisible(true);
            GameController.pause(game);
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

    public static void changeMenu(Game game) {
        switch (game.getGameMode()) {
            case GameConstDataUtil.READY_MODE:
                GameMenuBar menuBar = game.getUi().getGameWin().getGameMenuBar();
                HelpPanel helpPanel = game.getUi().getInfoWin().getInfoMainPanel().getHelpPanel();
                menuBar.pauseGame.setEnabled(false);
                menuBar.continueGame.setEnabled(false);
                menuBar.customMode.setEnabled(true);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(true);
                menuBar.restartGame.setEnabled(false);
                helpPanel.msOpt.setEnabled(true);
                helpPanel.keyOpt.setEnabled(true);
                break;
            case GameConstDataUtil.RUNNING_MODE:
                helpPanel = game.getUi().getInfoWin().getInfoMainPanel().getHelpPanel();
                menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(true);
                menuBar.continueGame.setEnabled(false);
                menuBar.customMode.setEnabled(false);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(false);
                menuBar.restartGame.setEnabled(false);
                helpPanel.msOpt.setEnabled(false);
                helpPanel.keyOpt.setEnabled(false);
                break;
            case GameConstDataUtil.PAUSE_MODE:
                menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(false);
                menuBar.continueGame.setEnabled(true);
                menuBar.customMode.setEnabled(false);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(false);
                menuBar.restartGame.setEnabled(true);
                break;
            case GameConstDataUtil.END_MODE:
                menuBar = game.getUi().getGameWin().getGameMenuBar();
                menuBar.pauseGame.setEnabled(false);
                menuBar.continueGame.setEnabled(false);
                menuBar.customMode.setEnabled(false);
                menuBar.exitGame.setEnabled(true);
                menuBar.startGame.setEnabled(false);
                menuBar.restartGame.setEnabled(false);
                break;
        }
    }

    public static void refreshInfoPanel(Game game) {
        GameMainPanel gameMainPanel = game.getUi().getGameWin().getGameMainPanel();
        GameInformationPanel panel = gameMainPanel.getGameInformationPanel();
        GamePanel gamePanel = gameMainPanel.getGamePanel();
        Player player = game.getPlayer();

        panel.nuclearNum.setText(String.valueOf(gamePanel.getHeroPlane().getNuclearNum()));
        panel.score.setText(String.valueOf(game.getPlayer().getScore()));
        panel.playerName.setText(game.getPlayer().getPlayerName());
        panel.life.setText(String.valueOf(gamePanel.getHeroPlane().getLife()));
        GameLevel gameLevel = game.getGameLevel();
        panel.restEnemyPlaneQuantity.setText(String.valueOf(gameLevel.getCommonEnemyPlaneQuantity() + gameLevel.getPromotedEnemyPlaneQuantity() - gameLevel.getCommonDeadCount() - gameLevel.getPromoteDeadCount() + gameLevel.getBossQuantity() - gameLevel.getBossDeadCount()));
        panel.passLineEnemyPlaneQuantity.setText(String.valueOf(game.getGameLevel().getPassLineEnemyQuantity()));
        panel.commonNum.setText(String.valueOf(gameLevel.getCommonEnemyPlaneQuantity() - gameLevel.getCommonDeadCount()));
        panel.promoteNum.setText(String.valueOf(gameLevel.getPromotedEnemyPlaneQuantity() - gameLevel.getPromoteDeadCount()));
        panel.bossNum.setText(String.valueOf(gameLevel.getBossQuantity() - gameLevel.getBossDeadCount()));
        panel.historyScore.setText(String.valueOf(player.getTotalScore()));
        gameMainPanel.repaint();
    }

    public static Image stateScreen(Game game){
        switch (game.getGameMode()){
            case GameConstDataUtil.READY_MODE:
                return GameConstResourceUtil.START_SCREEN;
            case GameConstDataUtil.PAUSE_MODE:
                return GameConstResourceUtil.PAUSE_SCREEN;
            default:
                return null;
        }
    }

    public static void gamePaneEndPaneExchange(Game game, String mode, String endMode){
        GameMainPanel gameMainPanel = game.getUi().getGameWin().getGameMainPanel();
        GamePanel gamePanel = gameMainPanel.getGamePanel();
        GameVicPanel gameVicPanel = gameMainPanel.getGameVicPanel();
        if (mode.equals(GameConstStr.TO_END_PANE)){
            gameMainPanel.remove(gamePanel);
            if (endMode.equals(GameConstStr.LEVEL_COMPLETE)){
                gameVicPanel.countLabel.setText("关卡通过！  秒后将进入下一关");
            }
            if (endMode.equals(GameConstStr.LEVEL_FAILED)){
                gameVicPanel.countLabel.setText("游戏失败！  秒后将重新开始");
            }
            gameMainPanel.add(gameVicPanel);
            gameMainPanel.repaint();
            gameMainPanel.revalidate();
        }
        if (mode.equals(GameConstStr.TO_GAME_PANE)){
            gameMainPanel.remove(gameVicPanel);
            gameMainPanel.add(gamePanel);
            gameMainPanel.repaint();
            gameMainPanel.revalidate();
        }
    }

    public static void toListWin(Game game, int mode){
        if (mode == GameConstDataUtil.LOGIN_MODE){
            LoginWin loginWin = game.getUi().getLoginWin();
            loginWin.setEnabled(false);
        }else if (mode == GameConstDataUtil.RUNNING_MODE){
            GameWin gameWin = game.getUi().getGameWin();
            gameWin.setEnabled(false);
        }
        refreshListPane(game);
        ListWin listWin = game.getUi().getListWin();
        listWin.setVisible(true);

    }
    public static void refreshListPane(Game game){
        JDBCUtil jdbcUtil = new JDBCUtil();
        ListPanel listPanel = game.getUi().getListWin().getListPanel();
        listPanel.setPlayerList(jdbcUtil.getList());
        listPanel.setList();
    }

    public static void refreshYZM(Game game){
        LoginPanel loginPanel = game.getUi().getLoginWin().getLoginMainPanel().getLoginPanel();
        loginPanel.YZM.setText(GameController.code());
        loginPanel.repaint();
    }
}
