package control.listener;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameController;
import model.FlyingObject;
import model.Game;
import model.maingame.effectiveobject.NuclearWeapon;
import view.gamewindows.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听器
 */
public class KeyLis implements KeyListener {
    private final Game game;
    private final String mode;

    /**
     * 构造函数
     *
     * @param game 游戏对象
     * @param mode 模式
     */
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
        if (game.getGameMode() == GameConstDataUtil.READY_MODE) {
            if (e.getKeyCode() == 85) {
                GameController.start(game);
            }
        }

        if (game.getOperateWay().equals(GameConstStr.KEYBOARD_CONTROL)) {
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            switch (game.getGameMode()) {
                case GameConstDataUtil.RUNNING_MODE:
                    FlyingObject heroPlane = gamePanel.getHeroPlane();
                    switch (e.getKeyCode()) {
                        case 83://s键
                            //System.out.println("s");
                            heroPlane.down = true;
                            break;
                        case 87://w键
                            //System.out.println("w");
                            heroPlane.setImg(GameConstResourceUtil.HERO_UP);
                            heroPlane.up = true;
                            break;
                        case 65://a键
                            //System.out.println("a");
                            heroPlane.left = true;
                            break;
                        case 68://d键
                            //System.out.println("d");
                            heroPlane.right = true;
                            break;
                        case 32://空格键
                            gamePanel.getHeroPlane().isAtk = true;
                            break;
                        case 72://h键
                            System.out.println("nuclear");
                            NuclearWeapon.boom(game);
                            break;
                        case 73://i键
                            GameController.pause(game);
                            break;

                        default:
                            System.out.println(e.getKeyCode());
                            break;
                    }
                    break;
                case GameConstDataUtil.PAUSE_MODE:
                    if (e.getKeyCode() == 79) {//o键
                        GameController.continueGame(game);
                    }
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("\"" + e.getKeyCode() + "\"");
        if (game.getOperateWay().equals(GameConstStr.KEYBOARD_CONTROL)) {
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            if (game.getGameMode() == GameConstDataUtil.RUNNING_MODE) {
                if (mode.equals(GameConstStr.MAIN_GAME)) {
                    FlyingObject heroPlane = gamePanel.getHeroPlane();
                    switch (e.getKeyCode()) {
                        case 83://s键
                            heroPlane.down = false;
                            break;
                        case 87://w键
                            heroPlane.up = false;
                            heroPlane.setImg(GameConstResourceUtil.HERO_DOWN);
                            break;
                        case 65://a键
                            heroPlane.left = false;
                            break;
                        case 68://d键
                            heroPlane.right = false;
                            break;
                        case 32://空格键
                            gamePanel.getHeroPlane().isAtk = false;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
