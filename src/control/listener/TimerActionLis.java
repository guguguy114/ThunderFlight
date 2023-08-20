package control.listener;

import control.GameConstDataUtil;
import control.GameConstStr;
import control.GameController;
import control.GameUIController;
import model.BackGround;
import model.FlyingObject;
import model.Game;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;
import view.gamewindows.GameVicPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionLis implements ActionListener {
    private final Game game;
    private final String mode;
    private int tik, tik2, tik3;
    private int key, key2, key3;
    private FlyingObject flyingObject;

    /**
     * 全局计时器使用的构造函数
     * @param game 游戏对象
     * @param mode 计时器模式
     */
    public TimerActionLis(Game game, String mode) {
        switch (mode) {
            case GameConstStr.GLOBAL:
                key = 1;
                key2 = 120;
                key3 = 1000;
                break;
            case GameConstStr.LOCAL:
                key = 200;
                break;
            case GameConstStr.ANIMATION:
                key = 10;
                break;
            case GameConstStr.READY_TO_NEXT_LEVEL:
            case GameConstStr.READY_TO_RESTART_LEVEL:
                key2 = GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK;
                key = 100;
                break;
        }
        this.game = game;
        this.mode = mode;
    }

    /**
     * 飞行物内类局部计时器
     * @param game 游戏对象
     * @param flyingObject 存在于的飞行物
     * @param mode 模式
     */
    public TimerActionLis(Game game, FlyingObject flyingObject, String mode) {
        this.game = game;
        switch (mode) {
            case GameConstStr.HERO_NAME:
                this.mode = GameConstStr.HERO_NAME;
                key = 10;
                break;
            case GameConstStr.ENEMY:
                this.mode = GameConstStr.ENEMY;
                key = 100;
                break;
            case GameConstStr.DEAD:
                this.mode = GameConstStr.DEAD;
                key = 10;
                tik2 = 0;
                break;
            case GameConstStr.HERO_STATE_LAST:
                this.mode = GameConstStr.HERO_STATE_LAST;
                key = 500;
                break;
            default:
                this.mode = GameConstStr.LOCAL;
                break;
        }
        this.flyingObject = flyingObject;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (mode) {
                //全局模式
            case GameConstStr.GLOBAL:
                GameController.judgeFail(game);
                GameController.objectsDisappear(game);
                GameController.allDetect(game);
                GameController.objectsMove(game);
                GameUIController.refreshInfoPanel(game);


                ++tik;
                if (tik == key) {
                    BackGround backGround = game.getGameLevel().getBackGround();
                    if (backGround.getObjY() == -800) {
                        backGround.setObjY(0);
                    } else {
                        backGround.setObjY(backGround.getObjY() - 1);
                    }
                    tik = 0;
                }

                ++tik2;
                if (tik2 == key2) {
                    GameController.createFlyingObject(game);
                    tik2 = 0;
                }

                ++tik3;
                if (tik3 == key3){
                    System.out.println("tik");
                    tik3 = 0;
                }
                break;


                //某局部模式
            case GameConstStr.LOCAL:
                break;


                //死亡计时器模式
            case GameConstStr.DEAD:
                GamePanel gamePanel;
                if (flyingObject.getDeadImgList().size() != 0){
                    flyingObject.setImg(flyingObject.getDeadImgList().get(tik2));
                    tik++;
                    if (tik == key) {
                        ++tik2;
                        tik = 0;
                    }
                }
                //System.out.println(tik2);
                if (tik2 == flyingObject.getDeadImgList().size()) {
                    flyingObject.out = true;
                    flyingObject.getDeadTimer().getTimer().stop();
                    tik2 = 0;
                }
                break;


                //动画计时器模式
            case GameConstStr.ANIMATION:
                gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                ++tik;
                if (tik == key) {
                    GameController.changeObjectAnimation(gamePanel);
                    //System.out.println("animation_acting");
                    tik = 0;
                }
                break;


                //敌机攻击计时器模式
            case GameConstStr.ENEMY:
                if (flyingObject != null) {
                    ++tik;
                    if (tik == key) {
                        //System.out.println("atkFrom " + flyingObject.hashCode());
                        flyingObject.attack(game);
                        tik = 0;
                    }
                    if (flyingObject.out) {
                        flyingObject = null;
                    }
                }
                break;


                //英雄攻击计时器模式
            case GameConstStr.HERO_NAME:
                ++tik;
                if (tik == key) {
                    flyingObject.attack(game);
                    tik = 0;
                }
                break;

                //英雄进入特殊状态计时器，用于计时特殊状态并在指定时间内结束状态
            case GameConstStr.HERO_STATE_LAST:
                ++tik;
                if (tik == key) {
                    HeroPlane heroPlane = (HeroPlane) flyingObject;
                    heroPlane.atkMode = GameConstStr.COMMON_ATK_MODE;
                    tik = 0;
                    //System.out.println("time_out");
                    heroPlane.stateTimer.getTimer().stop();
                }
                break;

            case GameConstStr.READY_TO_NEXT_LEVEL:
                GameVicPanel gameVicPanel = game.getUi().getGameWin().getGameMainPanel().getGameVicPanel();
                ++tik;
                if (tik == key){
                    --key2;
                    gameVicPanel.count.setText(String.valueOf(key2));
                    gameVicPanel.repaint();
                    if (key2 == 0){
                        System.out.println("levelChange");
                        gameVicPanel.getTempTimer().getTimer().stop();
                        GameController.levelChange(game, GameConstStr.COMMON_MODE);
                        GameUIController.gamePaneEndPaneExchange(game, GameConstStr.TO_GAME_PANE, null);
                        GameController.continueGame(game);
                        key2 = GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK;
                    }
                    tik = 0;
                }
                break;
            case GameConstStr.READY_TO_RESTART_LEVEL:
                gameVicPanel = game.getUi().getGameWin().getGameMainPanel().getGameVicPanel();
                ++tik;
                if (tik == key){
                    --key2;
                    gameVicPanel.count.setText(String.valueOf(key2));
                    gameVicPanel.repaint();
                    if (key2 == 0){
                        System.out.println("levelRestart");
                        gameVicPanel.getTempTimer().getTimer().stop();
                        GameController.restart(game);
                        GameUIController.gamePaneEndPaneExchange(game, GameConstStr.TO_GAME_PANE, null);
                        GameController.continueGame(game);
                        key2 = GameConstDataUtil.DEFAULT_TO_NEXT_LEVEL_TIK;
                    }
                    tik = 0;
                }
                break;
        }
    }

    /**
     * 析构函数
     */
    protected void finalize() {
        //System.out.println("removed_timerLis");
    }
}
