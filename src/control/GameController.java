package control;

import model.*;
import model.maingame.effectiveobject.Bee;
import model.maingame.effectiveobject.DoubleFire;
import model.maingame.effectiveobject.NuclearWeapon;
import model.maingame.enemy.CommonEnemyPlane;
import model.maingame.enemy.EnemyBoss;
import model.maingame.enemy.PromotedEnemyPlane;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;
import view.loginwindows.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    public static void applicationLaunch() {
        Game game = new Game();
        game.setGameMode(GameConstDataUtil.LOGIN_MODE);
    }

    /**
     * 生成验证码
     * @return 返回验证码
     */
    public static String code() {
//        Random r = new Random();
//        String strCode = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//        StringBuilder code = new StringBuilder();
//        for (int i = 0 ; i < 4 ; i ++){
//            code.append(strCode.charAt(r.nextInt(strCode.length())));
//        }
//        return code.toString();
        return "1";
    }

    public static void login(Game game) {// 一定要先创建gameWin再创建infoWin
        System.out.println(GameConstStr.LOGIN);
        JDBCUtil jdbcUtil = new JDBCUtil();
        LoginPanel panel = game.getUi().getLoginWin().getLoginMainPanel().getLoginPanel();
        String acc, pwd;
        acc = panel.accountPutIn.getText();
        pwd = new String(panel.passwordPutIn.getPassword());
        Player player = jdbcUtil.login(acc, pwd);
        //System.out.println(player);
        if (panel.YZMPutIn.getText().equals(panel.YZM.getText())) {
            if (player != null) {
                game.setPlayer(player);
                System.out.println("{ acc = " + acc + " , pwd = " + pwd + " }");
                GameUIController.refreshInfoPanel(game);
                GameUIController.loginWinAndGameWinExchange(game, GameConstStr.TO_GAME_WIN);
                game.setGameMode(GameConstDataUtil.READY_MODE);
                GameUIController.changeMenu(game, game.getGameMode());
                game.getUi().getGameWin().setEnabled(false);
                game.getUi().getInfoWin().setVisible(true);
            } else {
                System.out.println("acc_or_pwd_error");
            }
        } else {
            System.out.println("YZM_error");
        }

    }

    public static void signUp(Game game) {
        System.out.println(GameConstStr.SIGNUP);
    }

    /**
     * 退出方法
     * @param game 游戏对象
     */
    public static void exit(Game game) {
        System.out.println("exiting_game");
        FlyingObject heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        heroPlane.stopFlyingObject();
        if (game.getGameMode() == GameConstDataUtil.RUNNING_MODE) {
            pause(game);
        }
        if (JOptionPane.showConfirmDialog(null, "是否退出游戏", "退出游戏", JOptionPane.YES_NO_OPTION) == 0) {
            System.out.println("exit_game");
            System.exit(0);
        } else {
            System.out.println("cancel_exit_game");
        }
    }

    /**
     * 创建飞行物
     * @param game 游戏对象
     */
    public static void createFlyingObject(Game game) {
        //System.out.println("creating_object");
        Random r = new Random();
        int key = r.nextInt(10);
        if (key <= 6) {
            createEnemyPlane(game);
        } else {
            createEffectiveObject(game);
        }
    }

    /**
     * 创建敌机
     * @param game 游戏对象
     */
    public static void createEnemyPlane(Game game) {
        GameLevel gameLevel = game.getGameLevel();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        //System.out.println("creating_enemy_plane");
        Random r = new Random();
        int key = r.nextInt(2);
        if (key == 0) {
            if (gameLevel.getCommonSummonCount() != gameLevel.getCommonEnemyPlaneQuantity()){
                int summonPoint = r.nextInt(GameConstDataUtil.GAME_PANEL_WIDTH - GameConstDataUtil.COMMON_ENEMY_PLANE_WIDTH);
                gamePanel.getPlaneList().add(new CommonEnemyPlane(CommonEnemyPlane.randomImg(), summonPoint, -40, game));
            }else {
                key = 1;
            }
        }
        if (key == 1){
            if (gameLevel.getPromoteSummonCount() != gameLevel.getPromotedEnemyPlaneQuantity()){
                int summonPoint = r.nextInt(GameConstDataUtil.GAME_PANEL_WIDTH - GameConstDataUtil.PROMOTE_ENEMY_PLANE_WIDTH);
                gamePanel.getPlaneList().add(new PromotedEnemyPlane(summonPoint, -GameConstDataUtil.PROMOTE_ENEMY_PLANE_HEIGHT, game));
            }
        }
        if (gameLevel.getPromoteSummonCount() == gameLevel.getPromotedEnemyPlaneQuantity() && gameLevel.getCommonSummonCount() == gameLevel.getCommonEnemyPlaneQuantity()){
            gamePanel.getPlaneList().add(new EnemyBoss((GameConstDataUtil.GAME_PANEL_WIDTH - GameConstDataUtil.BOSS_WIDTH) / 2 , -40, game));
        }
    }

    /**
     * 创建增益物品
     * @param game 游戏对象
     */
    public static void createEffectiveObject(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        //System.out.println("creating_effective_object");
        Random r = new Random();
        int key = r.nextInt(3);
        int summonPoint = r.nextInt(GameConstDataUtil.GAME_PANEL_WIDTH);
        int summonPointY = -80;
        switch (key) {
            case 0:
                gamePanel.getEffectiveObjectList().add(new Bee(game, summonPoint, summonPointY));
                break;
            case 1:
                gamePanel.getEffectiveObjectList().add(new DoubleFire(game, summonPoint, summonPointY));
                break;
            case 2:
                gamePanel.getEffectiveObjectList().add(new NuclearWeapon(game, summonPoint, summonPointY));
                break;
        }
    }

    /**
     * 绘制游戏界面所有对象
     * @param g 游戏界面的绘制工具
     * @param gamePanel 游戏界面
     */
    public static void drawPane(Graphics g, GamePanel gamePanel) {
        gamePanel.getBackGround().draw(g);
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.draw(g);
            }
        }
    }

    public static void objectsMove(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.move(game);
            }
        }
    }

    /**
     * 飞行物越界清除
     *
     * @param game 所属游戏对象
     */
    public static void objectsDisappear(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        List<FlyingObject> removeList = new ArrayList<>();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                if (flyingObject.isDisappear(gamePanel)){
                    removeList.add(flyingObject);
                }
            }
        }
        for (FlyingObject flyingObject : removeList){
            flyingObject.dead(game);
            for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
                totalList.remove(flyingObject);
            }
        }
    }

    /**
     *
     * 更改游戏对象动画
     * @param gamePanel 游戏页面
     */
    public static void changeObjectAnimation(GamePanel gamePanel) {
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.changeAnimation();
            }
        }
    }

    public static void pause(Game game) {
        game.getTimers().getGlobalTimer().getTimer().stop();
        game.getTimers().getAnimationTimer().getTimer().stop();
        stopCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.PAUSE_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.PAUSE_MODE);
    }

    /**
     * 继续游戏方法
     * @param game 游戏对象
     */
    public static void continueGame(Game game) {
        game.getTimers().getGlobalTimer().getTimer().start();
        game.getTimers().getAnimationTimer().getTimer().start();
        restartCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.RUNNING_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.RUNNING_MODE);
    }

    public static void stopCreateAmmo(GamePanel gamePanel) {
        for (FlyingObject flyingObject : gamePanel.getPlaneList()){
            if (!(flyingObject instanceof HeroPlane)){
                flyingObject.getAttackTimer().getTimer().stop();
            }
        }
    }

    public static void restartCreateAmmo(GamePanel gamePanel) {
        for (FlyingObject flyingObject : gamePanel.getPlaneList()){
            flyingObject.getAttackTimer().getTimer().start();
        }
    }

    public static void removeObj(Game game, FlyingObject objIn) {
        if (objIn.out){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()) {
                totalList.remove(objIn);
            }
        }
    }

    public static void setKeyOpt(Game game) {
        game.setOperateWay(GameConstStr.KEYBOARD_CONTROL);
        GameUIController.toGameWin(game);
    }

    public static void setMouseOpt(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getHeroPlane().stopFlyingObject();
        game.setOperateWay(GameConstStr.MOUSE_CONTROL);
        GameUIController.toGameWin(game);
    }

    /**
     * 开始游戏
     * @param game 游戏对象
     */
    public static void start(Game game) {
        game.getTimers().getGlobalTimer().getTimer().start();
        game.getTimers().getAnimationTimer().getTimer().start();
        restartCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.RUNNING_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.RUNNING_MODE);
    }

    public static void allDetect(Game game){
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.hitDetect(game);
            }
        }
    }
}
