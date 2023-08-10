package control.listener;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import model.FlyingObject;
import model.Game;
import model.maingame.effectiveobject.NuclearWeapon;
import view.gamewindows.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLis implements KeyListener {
    private final Game game;
    private final String mode;

    public KeyLis(Game game, String mode) {
        this.game = game;
        this.mode = mode;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (game.getGameMode() == GameConstDataUtil.RUNNING_MODE) {
            switch (mode) {
                case GameConstStr.MAIN_GAME:
                    FlyingObject heroPlane = gamePanel.getHeroPlane();
                    switch (e.getKeyCode()) {
                        case 83://s键
                            //System.out.println("s");
                            heroPlane.isDown = true;
                            break;
                        case 87://w键
                            //System.out.println("w");
                            heroPlane.setObjImg(GameConstResourceUtil.HERO_UP);
                            heroPlane.isUp = true;
                            break;
                        case 65://a键
                            //System.out.println("a");
                            heroPlane.isLeft = true;
                            break;
                        case 68://d键
                            //System.out.println("d");
                            heroPlane.isRight = true;
                            break;
                        case 32:
                            gamePanel.getHeroPlane().isAtk = true;
                            break;
                        case 72:
                            System.out.println("nuclear");
                            NuclearWeapon.boom(game);
                            break;
                        default:
                            System.out.println(e.getKeyCode());
                            break;
                    }
                    break;
                case GameConstStr.LOGIN:
                    System.out.println(e.getKeyCode());
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        if (game.getGameMode() == GameConstDataUtil.RUNNING_MODE) {
            if (mode.equals(GameConstStr.MAIN_GAME)) {
                FlyingObject heroPlane = gamePanel.getHeroPlane();
                switch (e.getKeyCode()) {
                    case 83://s键
                        heroPlane.isDown = false;
                        break;
                    case 87://w键
                        heroPlane.isUp = false;
                        heroPlane.setObjImg(GameConstResourceUtil.HERO_DOWN);
                        break;
                    case 65://a键
                        heroPlane.isLeft = false;
                        break;
                    case 68://d键
                        heroPlane.isRight = false;
                        break;
                    case 32:
                        gamePanel.getHeroPlane().isAtk = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
