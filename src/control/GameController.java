package control;

import model.*;
import model.maingame.ammo.Ammo;
import model.maingame.effectiveobject.Bee;
import model.maingame.effectiveobject.DoubleFire;
import model.maingame.effectiveobject.EffectiveObject;
import model.maingame.effectiveobject.NuclearWeapon;
import model.maingame.enemy.CommonEnemyPlane;
import model.maingame.enemy.EnemyPlane;
import model.maingame.enemy.PromotedEnemyPlane;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;
import view.loginwindows.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameController {
    public static void applicationLaunch() {
        Game game = new Game();
        game.setGameMode(GameConstDataUtil.LOGIN_MODE);
    }

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

    public static void createEnemyPlane(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        //System.out.println("creating_enemy_plane");
        Random r = new Random();
        int key = r.nextInt(2);
        if (key == 0) {
            int summonPoint = r.nextInt(381);
            gamePanel.getPlaneList().add(new CommonEnemyPlane(CommonEnemyPlane.randomImg(), summonPoint, -40, game));
            summonPoint = r.nextInt(381) + 380;
            gamePanel.getPlaneList().add(new CommonEnemyPlane(CommonEnemyPlane.randomImg(), summonPoint, -40, game));
        } else {
            int summonPoint = r.nextInt(GameConstDataUtil.GAME_PANEL_WIDTH - GameConstDataUtil.PROMOTE_ENEMY_PLANE_WIDTH);
            gamePanel.getPlaneList().add(new PromotedEnemyPlane(summonPoint, -90, game));
        }

    }

    public static void createEffectiveObject(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        //System.out.println("creating_effective_object");
        Random r = new Random();
        int key = r.nextInt(3);
        int summonPoint = r.nextInt(GameConstDataUtil.GAME_PANEL_WIDTH - 50);
        switch (key) {
            case 0:
                gamePanel.getEffectiveObjectList().add(new Bee(game, summonPoint, -80));
                break;
            case 1:
                gamePanel.getEffectiveObjectList().add(new DoubleFire(game, summonPoint, -80));
                break;
            case 2:
                gamePanel.getEffectiveObjectList().add(new NuclearWeapon(game, summonPoint, -50));
                break;
        }
    }

    public static void drawPane(Graphics g, GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        do {
            FlyingObject temp = iterator.next();
            temp.draw(g);
        } while (iterator.hasNext());

        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                temp.draw(g);
            } while (iterator.hasNext());
        }

        Iterator<EffectiveObject> iteratorE = gamePanel.getEffectiveObjectList().iterator();
        if (iteratorE.hasNext()) {
            do {
                EffectiveObject temp = iteratorE.next();
                temp.draw(g);
            } while (iteratorE.hasNext());
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
        Iterator<EffectiveObject> iteratorE = gamePanel.getEffectiveObjectList().iterator();
        if (iteratorE.hasNext()) {
            do {
                EffectiveObject temp = iteratorE.next();
                temp.move();
            } while (iteratorE.hasNext());
        }
    }

    /**
     * 飞行物越界清除
     *
     * @param gamePanel 所属游戏页面
     */
    public static void objectsDisappear(GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        List<FlyingObject> removeList = new ArrayList<>();
        do {
            FlyingObject temp = iterator.next();
            if (temp.isDisappear(gamePanel)) {
                removeList.add(temp);
            }
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                if (temp.isDisappear(gamePanel)) {
                    removeList.add(temp);
                }
            } while (iterator.hasNext());
        }
        Iterator<EffectiveObject> iteratorE = gamePanel.getEffectiveObjectList().iterator();
        if (iteratorE.hasNext()) {
            do {
                EffectiveObject temp = iteratorE.next();
                if (temp.isDisappear(gamePanel)) {
                    removeList.add(temp);
                }
            } while (iteratorE.hasNext());
        }

        iterator = removeList.iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                if (temp.getObjectName().equals(GameConstStr.AMMO_NAME)) {
                    gamePanel.getAmmoList().remove(temp);
                    //System.out.println("remove_ammo " + temp.hashCode());
                }
                if (temp.getObjectName().equals(GameConstStr.ENEMY_PLANE_NAME)) {
                    //temp.getAttackTimer().getTimer().stop();
                    temp.getAttackTimer().setTimer(null);
                    temp.setAttackTimer(null);
                    temp.isOut = true;
                    gamePanel.getPlaneList().remove(temp);
                    //System.out.println("remove_plane " + temp.hashCode());

                }
                if (temp.getObjectName().equals(GameConstStr.EFFECT_OBJECT_NAME)) {

                    gamePanel.getEffectiveObjectList().remove((EffectiveObject) temp);
                }
            } while (iterator.hasNext());
        }
    }

    public static void changeObjectAnimation(GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        do {
            FlyingObject temp = iterator.next();
            //System.out.println("changing_plane_animation");
            temp.changeAnimation();
        } while (iterator.hasNext());
        iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                //System.out.println("changing_ammo_animation");
                temp.changeAnimation();
            } while (iterator.hasNext());
        }
        Iterator<EffectiveObject> iteratorE = gamePanel.getEffectiveObjectList().iterator();
        if (iteratorE.hasNext()) {
            do {
                EffectiveObject temp = iteratorE.next();
                temp.changeAnimation();
            } while (iteratorE.hasNext());
        }
    }

    public static void pause(Game game) {
        game.getTimers().getGlobalTimer().getTimer().stop();
        game.getTimers().getAnimationTimer().getTimer().stop();
        stopCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.PAUSE_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.PAUSE_MODE);
    }

    public static void continueGame(Game game) {
        game.getTimers().getGlobalTimer().getTimer().start();
        game.getTimers().getAnimationTimer().getTimer().start();
        restartCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.RUNNING_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.RUNNING_MODE);
    }

    public static void stopCreateAmmo(GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                //System.out.println("changing_ammo_animation");
                temp.getAttackTimer().getTimer().stop();
            } while (iterator.hasNext());
        }
    }

    public static void restartCreateAmmo(GamePanel gamePanel) {
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                //System.out.println("changing_ammo_animation");
                temp.getAttackTimer().getTimer().start();
            } while (iterator.hasNext());
        }
    }

    /**
     * 用于子弹碰撞检测
     *
     * @param game       游戏对象
     * @param objIn      需要被检测的飞行物
     * @param ammoBelong 撞击飞行物的子弹所属方
     * @return 判断十分撞击
     */
    public static boolean gameObjectAmmoHitDetect(Game game, FlyingObject objIn, String ammoBelong) {
        int x = objIn.getObjX();
        int y = objIn.getObjY();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        Iterator<FlyingObject> iterator = gamePanel.getAmmoList().iterator();
        if (iterator.hasNext()) {
            do {
                Ammo temp = (Ammo) iterator.next();
                if (temp.getObjX() + temp.getObjectWidth() > x && temp.getObjX() < x + objIn.getObjectWidth() && temp.getObjY() + temp.getObjectHeight() > y && temp.getObjY() < y + objIn.getObjectHeight()) {
                    if (temp.getBelongTo().equals(ammoBelong)) {
                        temp.hitFeedback(game, objIn);
                        //System.out.println("ammo_hit");
                        return true;
                    }
                }
            } while (iterator.hasNext());
        }
        return false;
    }

    public static void enemyAmmoHitHero(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        HeroPlane heroPlane = gamePanel.getHeroPlane();
        if (gameObjectAmmoHitDetect(game, heroPlane, GameConstStr.ENEMY)) {

        }
    }

    public static void allHit(Game game) {
        enemyAmmoHitHero(game);
        heroAmmoHitEnemy(game);
        heroHitEffectObject(game);
        heroHitEnemy(game);
    }

    public static void heroAmmoHitEnemy(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                if (temp.getObjectName().equals(GameConstStr.COMMON_ENEMY_PLANE_NAME)) {
                    if (gameObjectAmmoHitDetect(game, temp, GameConstStr.FRIEND)) {
                        //System.out.println("hit_enemy");
                        if (temp.getLife() == 0) {
                            temp.dead(game);
                        }
                    }
                }
            } while (iterator.hasNext());
        }
    }

    public static void removeAmmo(Game game, Ammo ammo) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        ammo.dead(game);
        gamePanel.getAmmoList().remove(ammo);
    }

    public static void heroHitEffectObject(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        HeroPlane heroPlane = gamePanel.getHeroPlane();
        ArrayList<EffectiveObject> removeList = new ArrayList<>();
        int x = heroPlane.getObjX();
        int y = heroPlane.getObjY();
        Iterator<EffectiveObject> iterator = gamePanel.getEffectiveObjectList().iterator();
        if (iterator.hasNext()) {
            do {
                EffectiveObject temp = iterator.next();
                if (temp.getObjX() + temp.getObjectWidth() > x && temp.getObjX() < x + heroPlane.getObjectWidth() && temp.getObjY() + temp.getObjectHeight() > y && temp.getObjY() < y + heroPlane.getObjectHeight()) {
                    //System.out.println("reach_eo");
                    temp.hitFeedback();
                    removeList.add(temp);
                }
            } while (iterator.hasNext());
        }

        Iterator<EffectiveObject> iteratorE = removeList.iterator();
        if (iteratorE.hasNext()) {
            do {
                EffectiveObject temp = iteratorE.next();
                gamePanel.getEffectiveObjectList().remove(temp);
            } while (iteratorE.hasNext());
        }
    }

    public static void heroHitEnemy(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        HeroPlane heroPlane = gamePanel.getHeroPlane();
        int x = heroPlane.getObjX();
        int y = heroPlane.getObjY();
        Iterator<FlyingObject> iterator = gamePanel.getPlaneList().iterator();
        if (iterator.hasNext()) {
            do {
                FlyingObject temp = iterator.next();
                if (temp.getObjectName().equals(GameConstStr.COMMON_ENEMY_PLANE_NAME)) {
                    if (temp.getObjX() + temp.getObjectWidth() > x && temp.getObjX() < x + heroPlane.getObjectWidth() && temp.getObjY() + temp.getObjectHeight() > y && temp.getObjY() < y + heroPlane.getObjectHeight()) {
                        if (temp.isHitBal()) {
                            EnemyPlane tempE = (EnemyPlane) temp;
                            tempE.hitFeedback(game);
                            tempE.dead(game);
                            //System.out.println("hit_enemy_plane");
                        }
                    }
                }
            } while (iterator.hasNext());
        }
    }

    public static void removeEnemyPlane(GamePanel gamePanel, ArrayList<EnemyPlane> removeList) {
        Iterator<EnemyPlane> iteratorE = removeList.iterator();
        if (iteratorE.hasNext()) {
            do {
                EnemyPlane temp = iteratorE.next();
                temp.setAttackTimer(null);
                temp.isOut = true;
                gamePanel.getPlaneList().remove(temp);
            } while (iteratorE.hasNext());
        }
    }

    public static void setKeyOpt(Game game) {
        game.setOperateWay(GameConstStr.KEYBOARD_CONTROL);
        GameUIController.toGameWin(game);
    }

    public static void setMouseOpt(Game game) {
        game.setOperateWay(GameConstStr.MOUSE_CONTROL);
        GameUIController.toGameWin(game);
    }

    public static void start(Game game) {
        game.getTimers().getGlobalTimer().getTimer().start();
        game.getTimers().getAnimationTimer().getTimer().start();
        restartCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.RUNNING_MODE);
        GameUIController.changeMenu(game, GameConstDataUtil.RUNNING_MODE);
    }

    public static boolean commonEnemyQuantity(GameLevel gameLevel) {
        return false;
    }
}
