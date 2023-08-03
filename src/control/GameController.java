package control;

import model.Game;
import model.maingame.hero.HeroPlane;

import javax.swing.*;
import java.util.Random;

public class GameController {
    public static void applicationLaunch(){
        Game game = new Game();
        game.setGameMode(GameConstDataUtil.LOGIN_MODE);
    }

    public static String code(){
        Random r = new Random();
        String strCode = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder code = new StringBuilder();
        for (int i = 0 ; i < 4 ; i ++){
            code.append(strCode.charAt(r.nextInt(strCode.length())));
        }
        return code.toString();
    }

    public static void login(Game game){// 一定要先创建gameWin再创建infoWin
        System.out.println(GameConstStr.LOGIN);
        GameUIController.loginWinAndGameWinExchange(game, GameConstStr.TO_GAME_WIN);
        game.getGlobalTimer().getTimer().start();
        game.getUi().getGameWin().setEnabled(false);
        game.getUi().getInfoWin().setVisible(true);
    }

    public static void signUp(Game game){
        System.out.println(GameConstStr.SIGNUP);
    }

    public static void exit(Game game){
        System.out.println("exiting_game");
        HeroPlane heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        heroPlane.stopHeroPlane();
        game.getGlobalTimer().getTimer().stop();
        if (JOptionPane.showConfirmDialog(null,"是否退出游戏", "退出游戏", JOptionPane.YES_NO_OPTION) == 0){
            System.out.println("exit_game");
            System.exit(0);
        }else {
            game.getGlobalTimer().getTimer().start();
            System.out.println("cancel_exit_game");
        }
    }
}
