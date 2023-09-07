package control;

import model.*;
import model.maingame.effectiveobject.Bee;
import model.maingame.effectiveobject.DoubleFire;
import model.maingame.effectiveobject.NuclearWeapon;
import model.maingame.enemy.CommonEnemyPlane;
import model.maingame.enemy.EnemyBoss;
import model.maingame.enemy.EnemyPlane;
import model.maingame.enemy.PromotedEnemyPlane;
import model.maingame.hero.HeroPlane;
import view.customwindows.CustomPanel;
import view.gamewindows.*;
import view.loginwindows.LoginPanel;
import view.loginwindows.SignUpPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        System.out.println(GameConstStr.REFRESH_YZM);
        Random r = new Random();
        String strCode = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder code = new StringBuilder();
        for (int i = 0 ; i < 4 ; i ++){
            code.append(strCode.charAt(r.nextInt(strCode.length())));
        }
        return code.toString();
        //return  "1";
    }

    public static void login(Game game) {// 一定要先创建gameWin再创建infoWin
        System.out.println(GameConstStr.LOGIN);
        JDBCUtil jdbcUtil = new JDBCUtil();
        LoginPanel panel = game.getUi().getLoginWin().getLoginMainPanel().getLoginPanel();
        String acc, pwd;
        acc = panel.accountPutIn.getText();
        pwd = new String(panel.passwordPutIn.getPassword());
        if (Objects.equals(acc, "") || pwd.equals("")){
            JOptionPane.showConfirmDialog(null, "输入为空", "登入失败", JOptionPane.DEFAULT_OPTION);
            return;
        }
        Player player = jdbcUtil.login(acc, pwd);
        //System.out.println(player);
        if (panel.YZMPutIn.getText().equalsIgnoreCase(panel.YZM.getText())) {
            if (player != null) {
                game.setPlayer(player);
                System.out.println("{ acc = " + acc + " , pwd = " + pwd + " }");
                GameUIController.refreshInfoPanel(game);
                GameUIController.loginWinAndGameWinExchange(game, GameConstStr.TO_GAME_WIN);
                game.setGameMode(GameConstDataUtil.READY_MODE);
                GameUIController.changeMenu(game);
                game.getUi().getGameWin().setEnabled(false);
                game.getUi().getInfoWin().setVisible(true);
                Music startMusic = new Music(Music.START_GAME, GameConstStr.MUSIC_EQ);
                startMusic.startMusic();
                game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel().miniMap.timerStart();
            } else {
                JOptionPane.showConfirmDialog(null, "账号或密码错误", "登入失败", JOptionPane.DEFAULT_OPTION);
                System.out.println("acc_or_pwd_error");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "验证码错误", "登入失败", JOptionPane.DEFAULT_OPTION);
            GameUIController.refreshYZM(game);
            System.out.println("YZM_error");
        }

    }

    public static void signUp(Game game) {
        SignUpPanel signUpPanel = game.getUi().getLoginWin().getLoginMainPanel().getSignUpPanel();
        JDBCUtil jdbcUtil = new JDBCUtil();
        String acc = signUpPanel.accountPutIn.getText();
        String pwd = new String(signUpPanel.passwordPutIn.getPassword());
        String pwdC = new String(signUpPanel.passwordConfirmPutIn.getPassword());
        String name = signUpPanel.playerNamePutIn.getText();
        String tip;
        if (!pwd.equals(pwdC)){
            System.out.println("fail_to_signUp");
            tip = "两次输入的密码不同";
        }else {
            if (jdbcUtil.signUp(acc, pwd, name)){
                tip = "注册成功";
            }else {
                tip = "注册失败:" + JDBCUtil.FAIL_SAME_ACC;
            }
        }
        JOptionPane.showConfirmDialog(null, tip, "注册", JOptionPane.DEFAULT_OPTION);
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
        if (game.getGameMode() == GameConstDataUtil.END_MODE){
            System.out.println("exit_game");
            System.exit(0);
        }else {
            if (JOptionPane.showConfirmDialog(null, "是否退出游戏", "退出游戏", JOptionPane.YES_NO_OPTION) == 0) {
                System.out.println("exit_game");
                System.exit(0);
            } else {
                System.out.println("cancel_exit_game");
            }
        }
    }

    /**
     * 创建飞行物
     * @param game 游戏对象
     */
    public static void createFlyingObject(Game game) {
        if (!game.getGameLevel().isComplete()){
            //System.out.println("creating_object");
            Random r = new Random();
            int key = r.nextInt(10);
            if (key <= 6) {
                createEnemyPlane(game);
            } else {
                createEffectiveObject(game);
            }
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
        if (gameLevel.getPromoteDeadCount() == gameLevel.getPromotedEnemyPlaneQuantity() && gameLevel.getCommonDeadCount() == gameLevel.getCommonEnemyPlaneQuantity() && gameLevel.getBossSummonCount() != gameLevel.getBossQuantity()){
            gamePanel.getPlaneList().add(new EnemyBoss((GameConstDataUtil.GAME_PANEL_WIDTH - GameConstDataUtil.BOSS_WIDTH) / 2 , -100, game));
        }
    }

    /**
     * 创建增益物品
     * @param game 游戏对象
     */
    public static void createEffectiveObject(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        HeroPlane heroPlane = gamePanel.getHeroPlane();
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
                if (heroPlane.getNuclearNum() < 2){
                gamePanel.getEffectiveObjectList().add(new NuclearWeapon(game, summonPoint, summonPointY));
                }
                break;
        }
    }

    /**
     * 绘制游戏界面所有对象
     *
     * @param g     游戏界面的绘制工具
     * @param panel 游戏界面
     * @param game 游戏对象
     */
    public static void drawPane(Graphics g, JPanel panel, Game game) {
        if (panel instanceof GamePanel){
            ((GamePanel) panel).getBackGround().draw(g, game);
            for (ArrayList<FlyingObject> totalList : ((GamePanel) panel).getTotalList()) {
                for (FlyingObject flyingObject : totalList) {
                    flyingObject.draw(g, game);
                }
            }
        }else if (panel instanceof GameInformationPanel){
            ((GameInformationPanel) panel).miniMap.draw(g, game);
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
        GameLevel gameLevel = game.getGameLevel();
        List<FlyingObject> removeList = new ArrayList<>();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                if ((flyingObject.out) && !(flyingObject instanceof HeroPlane)){
                    removeList.add(flyingObject);
                }
                if(flyingObject.isDisappear() && flyingObject instanceof EnemyPlane){
                    if (flyingObject instanceof EnemyBoss){
                        fail(game);
                    }
                    gameLevel.setPassLineEnemyQuantity(gameLevel.getPassLineEnemyQuantity() + 1);
                    ((EnemyPlane) flyingObject).deadCount(game);
                    removeList.add(flyingObject);
                }
                if (flyingObject.out && flyingObject instanceof HeroPlane){
                    flyingObject.dead(game);
                }
            }
        }
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            totalList.removeAll(removeList);
        }
    }

    /**
     *
     * 更改游戏对象动画
     * @param gameMainPanel 游戏页面
     */
    public static void changeObjectAnimation(GameMainPanel gameMainPanel) {
        GamePanel gamePanel = gameMainPanel.getGamePanel();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.changeAnimation();
            }
        }
        GameInformationPanel gameInformationPanel = gameMainPanel.getGameInformationPanel();
        gameInformationPanel.miniMap.changeAnimation();
    }

    public static void pause(Game game) {
        if (!(game.getGameMode() == GameConstDataUtil.READY_MODE)){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            HeroPlane heroPlane = gamePanel.getHeroPlane();
            GameLevel gameLevel = game.getGameLevel();
            heroPlane.isAtk = false;
            game.getTimers().getGlobalTimer().getTimer().stop();
            game.getTimers().getAnimationTimer().getTimer().stop();
            stopCreateAmmo(gamePanel);
            game.setGameMode(GameConstDataUtil.PAUSE_MODE);
            GameUIController.changeMenu(game);
            gamePanel.repaint();
            gameLevel.getBGM().stopMusic();
        }
    }

    /**
     * 继续游戏方法
     * @param game 游戏对象
     */
    public static void continueGame(Game game) {
        GameLevel gameLevel = game.getGameLevel();
        game.getTimers().getGlobalTimer().getTimer().start();
        game.getTimers().getAnimationTimer().getTimer().start();
        restartCreateAmmo(game.getUi().getGameWin().getGameMainPanel().getGamePanel());
        game.setGameMode(GameConstDataUtil.RUNNING_MODE);
        GameUIController.changeMenu(game);
        gameLevel.getBGM().startMusic();
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
        GameUIController.changeMenu(game);
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.getBGM().startMusic();
    }

    public static void allDetect(Game game){
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        for (ArrayList<FlyingObject> totalList: gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                flyingObject.hitDetect(game);
            }
        }
    }

    public static void levelComplete(Game game, String mode){
        Player player = game.getPlayer();
        GameVicPanel gameVicPanel;
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.getBGM().stopMusic();
        gameLevel.getBGM().resetMusic();
        if (game.getGameLevel().getLevelID() == 3 || game.getGameLevel().getLevelID() == 0){
            GameUIController.gamePaneEndPaneExchange(game, GameConstStr.TO_END_PANE, GameConstStr.LEVEL_FINAL);
            player.setTotalScore(player.getTotalScore() + player.getScore());
            JDBCUtil jdbcUtil = new JDBCUtil();
            jdbcUtil.updatePlayerData(player);
            if (JOptionPane.showConfirmDialog(null, "您已通关是否重新开始游戏", "游戏结束", JOptionPane.YES_NO_OPTION) == 0){
                restartJudge(game, GameConstStr.FINAL);
            }else {
                exit(game);
            }
        } else {
            pause(game);
            game.setGameMode(GameConstDataUtil.END_MODE);
            GameUIController.changeMenu(game);
            if (mode.equals(GameConstStr.LEVEL_COMPLETE)) {
                System.out.println(mode);
                gameVicPanel = game.getUi().getGameWin().getGameMainPanel().getGameVicPanel();
                gameVicPanel.count.setText(String.valueOf(GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK));
                GameUIController.gamePaneEndPaneExchange(game, GameConstStr.TO_END_PANE, GameConstStr.LEVEL_COMPLETE);
                gameVicPanel.readyToNextLevel(game);
            }
            if (mode.equals(GameConstStr.LEVEL_FAILED)) {
                Music failed = new Music(Music.GAME_OVER, GameConstStr.MUSIC_EQ);
                failed.startMusic();
                gameVicPanel = game.getUi().getGameWin().getGameMainPanel().getGameVicPanel();
                gameVicPanel.count.setText(String.valueOf(GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK));
                GameUIController.gamePaneEndPaneExchange(game, GameConstStr.TO_END_PANE, GameConstStr.LEVEL_FAILED);
                gameVicPanel.readyToRestartLevel(game);
            }
        }
    }

    public static void restartJudge(Game game, String mode){
        pause(game);
        if (mode.equals(GameConstStr.COMMON)){
            if (JOptionPane.showConfirmDialog(null, "是否重新开始游戏", "重新开始游戏", JOptionPane.YES_NO_OPTION) == 0) {
                restart(game);
            }
        }
        if (mode.equals(GameConstStr.FINAL)){
            Music startMusic = new Music(Music.START_GAME, GameConstStr.MUSIC_EQ);
            startMusic.startMusic();
            GameMainPanel gameMainPanel = game.getUi().getGameWin().getGameMainPanel();
            gameMainPanel.remove(gameMainPanel.getGameVicPanel());
            gameMainPanel.add(gameMainPanel.getGamePanel());
            restart(game);
        }
    }

    public static void restart(Game game) {
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.getBGM().stopMusic();
        gameLevel.getBGM().resetMusic();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        removeAllObject(game, gamePanel);
        Player player = game.getPlayer();
        player.setScore(0);
        JDBCUtil jdbcUtil = new JDBCUtil();
        game.setGameLevel(jdbcUtil.loadLevel(1));
        game.setGameMode(GameConstDataUtil.READY_MODE);
        gamePanel.setBackGround(game.getGameLevel().getBackGround());
        gamePanel.repaint();
        GameUIController.changeMenu(game);
        GameUIController.refreshInfoPanel(game);
        HeroPlane heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        heroPlane.setLife(GameConstDataUtil.DEFAULT_HERO_LIFE);
    }

    public static void levelChange(Game game, String mode){
        GameLevel gameLevel = game.getGameLevel();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        CustomPanel customPanel = game.getUi().getCustomWin().getCustomPanel();
        if (mode.equals(GameConstStr.COMMON_MODE)){
            JDBCUtil jdbcUtil = new JDBCUtil();
            game.setGameLevel(jdbcUtil.loadLevel(gameLevel.getLevelID() + 1));
            gamePanel.setBackGround(game.getGameLevel().getBackGround());
            removeAllObject(game, gamePanel);
            game.setGameMode(GameConstDataUtil.RUNNING_MODE);
            GameUIController.changeMenu(game);
            GameUIController.refreshInfoPanel(game);
        }
        if (mode.equals(GameConstStr.CUSTOM_MODE)){
            System.out.println(GameConstStr.CUSTOM_MODE);
            if (Objects.equals(customPanel.levelChoosePutIn.getSelectedItem(), GameConstStr.LEVEL_CUSTOM)){
                if (!Objects.equals(customPanel.commonQuantity.getText(), "") && !Objects.equals(customPanel.promoteQuantity.getText(), "") && !Objects.equals(customPanel.bossLife.getText(), "")) {
                    if (customPanel.isCustom()) {
                        System.out.println("{ CQ = " + customPanel.commonQuantity.getText() + " PQ = " + customPanel.promoteQuantity.getText() + " BL = " + customPanel.bossLife.getText() + " BG = " + customPanel.BG + " }");
                        customPanel.setValue();
                        game.setGameLevel(new GameLevel(customPanel.BG, GameConstStr.LEVEL_CUSTOM, customPanel.speedPutIn.getValue(), customPanel.getCQ(), customPanel.getPQ(), customPanel.getBL(), 0)); //这里写创建特定数值的自定义关卡
                    } else {
                        System.out.println("fail_to_change_level");
                    }
                } else {
                    System.out.println("fail_to_change_level_something_null");
                }
            }else {
                JDBCUtil jdbcUtil = new JDBCUtil();
                switch ((String) Objects.requireNonNull(customPanel.levelChoosePutIn.getSelectedItem())){
                    case GameConstStr.LEVEL_ONE:
                        game.setGameLevel(jdbcUtil.loadLevel(1));
                        break;
                    case GameConstStr.LEVEL_TWO:
                        game.setGameLevel(jdbcUtil.loadLevel(2));
                        break;
                    case GameConstStr.LEVEL_THREE:
                        game.setGameLevel(jdbcUtil.loadLevel(3));
                        break;
                }
            }
            game.getGameLevel().setSpeed(customPanel. speedPutIn.getValue());
            //System.out.println(customPanel.speedPutIn.getValue());
            gamePanel.setBackGround(game.getGameLevel().getBackGround());
            removeAllObject(game, gamePanel);
            game.setGameMode(GameConstDataUtil.RUNNING_MODE);
            GameUIController.changeMenu(game);
            GameUIController.refreshInfoPanel(game);
            continueGame(game);
            GameUIController.toGameWin(game);
        }
    }

    private static void removeAllObject(Game game, GamePanel gamePanel) {
        int life = gamePanel.getHeroPlane().getLife();
        gamePanel.setAmmoList(new ArrayList<>());
        gamePanel.setPlaneList(new ArrayList<>());
        gamePanel.setEffectiveObjectList(new ArrayList<>());
        gamePanel.setTotalList();
        gamePanel.getPlaneList().add(new HeroPlane(game, life));
    }

    public static void fail(Game game){
        levelComplete(game, GameConstStr.LEVEL_FAILED);
    }

    public static void judgeFail(Game game){
        GameLevel gameLevel = game.getGameLevel();
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        HeroPlane heroPlane = gamePanel.getHeroPlane();
        if ((heroPlane.getLife() <= 0 || gameLevel.getPassLineEnemyQuantity() >= 5)){
            fail(game);
        } else if (gameLevel.isComplete()  && gameLevel.isBossDead()){
            levelComplete(game, GameConstStr.LEVEL_COMPLETE);
        }
    }

    public static void process(Game game){
        judgeFail(game);
        objectsDisappear(game);
        allDetect(game);
        objectsMove(game);
        GameUIController.refreshInfoPanel(game);
    }

    public static void toList(Game game, int mode){
        GameUIController.toListWin(game, mode);
    }
}
