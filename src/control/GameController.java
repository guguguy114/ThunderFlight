package control;

import model.FlyingObject;
import model.Game;
import view.gamewindows.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        game.getAnimationTimer().getTimer().start();
        game.getUi().getGameWin().setEnabled(false);
        game.getUi().getInfoWin().setVisible(true);
    }

    public static void signUp(Game game){
        System.out.println(GameConstStr.SIGNUP);
    }

    public static void exit(Game game){
        System.out.println("exiting_game");
        FlyingObject heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        heroPlane.stopFlyingObject();
        game.getGlobalTimer().getTimer().stop();
        if (JOptionPane.showConfirmDialog(null,"是否退出游戏", "退出游戏", JOptionPane.YES_NO_OPTION) == 0){
            System.out.println("exit_game");
            System.exit(0);
        }else {
            game.getGlobalTimer().getTimer().start();
            System.out.println("cancel_exit_game");
        }
    }

    public static void createFlyingObject(){
        System.out.println("creating_object");
        Random r = new Random();
        int key = r.nextInt(10);
        if (key<=6){
            createEnemyPlane();
        }else {
            createEffectiveObject();
        }
    }

    public static void createEnemyPlane(){
        System.out.println("creating_enemy_plane");
    }

    public static void createEffectiveObject(){
        System.out.println("creating_effective_object");
    }
    public static void drawPane(Graphics g, GamePanel gamePanel){
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        do {
            FlyingObject temp = iterator.next();
            temp.draw(g);
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()){
            do {
                FlyingObject temp = iterator.next();
                temp.draw(g);
            } while (iterator.hasNext());
        }
    }
    public static void objectsMove(GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        do {
            FlyingObject temp = iterator.next();
            temp.move();
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                temp.move();
            } while (iterator.hasNext());
        }
    }

    public static void objectsDisappear(GamePanel gamePanel){
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        List<FlyingObject> removeList = new ArrayList<>();
        do {
            FlyingObject temp = iterator.next();
            if (temp.isDisappear(gamePanel)){
                removeList.add(temp);
            }
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                if (temp.isDisappear(gamePanel)){
                    removeList.add(temp);
                }
            } while (iterator.hasNext());
        }

        iterator = removeList.iterator();
        if (iterator.hasNext()){
            do {
                FlyingObject temp = iterator.next();
                if (temp.getObjectName().equals(GameConstStr.AMMO_NAME)) {
                    gamePanel.getAmmoList().remove(temp);
                    System.out.println("remove_ammo");
                }
                if (temp.getObjectName().equals(GameConstStr.PLANE_NAME)) {
                    gamePanel.getPlaneList().remove(temp);
                    System.out.println("remove_plane");
                }
            } while (iterator.hasNext());
        }
    }

    public static void changeObjectAnimation(GamePanel gamePanel){
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        do {
            FlyingObject temp = iterator.next();
            System.out.println("changing_plane_animation");
            temp.changeAnimation();
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()){
            do {
                FlyingObject temp = iterator.next();
                System.out.println("changing_ammo_animation");
                temp.changeAnimation();
            } while (iterator.hasNext());
        }
    }
}
