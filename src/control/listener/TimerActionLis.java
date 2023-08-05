package control.listener;

import control.GameConstStr;
import control.GameController;
import model.BackGround;
import model.Game;
import view.gamewindows.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionLis implements ActionListener {
    private Game game;
    private String mode;
    private int tik, tik2;
    private int key, key2;
    public TimerActionLis(Game game, String mode){
        switch (mode){
            case GameConstStr.GLOBAL:
                key = 1;
                key2 = 300;
                break;
            case GameConstStr.LOCAL:
                break;
            case GameConstStr.ANIMATION:
                key = 10;
                break;
        }
        this.game = game;
        this.mode = mode;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (mode){
            case GameConstStr.GLOBAL:
                GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                GameController.objectsMove(gamePanel);
                GameController.objectsDisappear(gamePanel);

                ++tik;
                if (tik == key){
                    //System.out.println(GameConstStr.GLOBAL);
                    BackGround backGround = game.getGameLevel().getBackGround1();
                    //System.out.println(backGround.getObjY());
                    if (backGround.getObjY() == -800){
                        backGround.setObjY(0);
                    }else {
                        backGround.setObjY(backGround.getObjY() - 1);
                    }
                    tik = 0;
                }

                ++tik2;
                if (tik2 == key2){
                    GameController.createFlyingObject();
                    tik2 = 0;
                }
                break;


            case GameConstStr.LOCAL:
                break;
            case GameConstStr.ANIMATION:
                gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();

                ++tik;
                if (tik == key){
                    GameController.changeObjectAnimation(gamePanel);
                    System.out.println("animation_acting");
                    tik = 0;
                }
                break;
        }
    }
}
