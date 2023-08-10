package control.listener;

import control.GameConstStr;
import control.GameController;
import control.GameUIController;
import model.BackGround;
import model.FlyingObject;
import model.Game;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionLis implements ActionListener {
    private final Game game;
    private final String mode;
    private int tik, tik2;
    private int key, key2;
    private FlyingObject flyingObject;

    public TimerActionLis(Game game, String mode) {
        switch (mode) {
            case GameConstStr.GLOBAL:
                key = 1;
                key2 = 120;
                break;
            case GameConstStr.LOCAL:
                key = 200;
                break;
            case GameConstStr.ANIMATION:
                key = 10;
                break;
        }
        this.game = game;
        this.mode = mode;
    }

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
            case GameConstStr.GLOBAL:
                GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                GameController.objectsMove(gamePanel);
                GameController.objectsDisappear(gamePanel);
                GameController.allHit(game);
                GameUIController.refreshInfoPanel(game);
                game.getUi().getGameWin().getGameMainPanel().repaint();

                ++tik;
                if (tik == key) {
                    //System.out.println(GameConstStr.GLOBAL);
                    BackGround backGround = game.getGameLevel().getBackGround();
                    //System.out.println(backGround.getObjY());
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
                break;


            case GameConstStr.LOCAL:

                break;
            case GameConstStr.DEAD:
                gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                flyingObject.setObjImg(flyingObject.getDeadImgList().get(tik2));
                tik++;
                if (tik == key) {
                    ++tik2;
                    tik = 0;
                }
                //System.out.println(tik2);
                if (tik2 == flyingObject.getDeadImgList().size()) {
                    flyingObject.isOut = true;
                    //System.out.println("666666");
                    flyingObject.getDeadTimer().getTimer().stop();
                    gamePanel.getPlaneList().remove(flyingObject);
                    tik2 = 0;
                }
                break;


            case GameConstStr.ANIMATION:
                gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();

                ++tik;
                if (tik == key) {
                    GameController.changeObjectAnimation(gamePanel);
                    //System.out.println("animation_acting");
                    tik = 0;
                }
                break;


            case GameConstStr.ENEMY:
                if (flyingObject != null) {
                    ++tik;
                    if (tik == key) {
                        //System.out.println("atkFrom " + flyingObject.hashCode());
                        flyingObject.attack(game);
                        tik = 0;
                    }
                    if (flyingObject.isOut) {
                        flyingObject = null;
                    }
                }
                break;

            case GameConstStr.HERO_NAME:
                ++tik;
                if (tik == key) {
                    flyingObject.attack(game);
                    tik = 0;
                }
                break;
            case GameConstStr.HERO_STATE_LAST:
                ++tik;
                if (tik == key) {
                    HeroPlane heroPlane = (HeroPlane) flyingObject;
                    heroPlane.atkMode = GameConstStr.COMMON_ATK_MODE;
                    tik = 0;
                    System.out.println("time_out");
                    heroPlane.stateTimer.getTimer().stop();
                }
                break;
        }
    }

    protected void finalize() {
        //System.out.println("removed_timerLis");
    }
}
