package control.listener;

import control.GameConstStr;
import model.BackGround;
import model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerActionLis implements ActionListener {
    private Game game;
    private String mode;
    private int tik;
    private int key;
    public TimerActionLis(Game game, String mode){
        switch (mode){
            case GameConstStr.GLOBAL:
                key = 1;
                break;
            case GameConstStr.LOCAL:
                break;
        }
        this.game = game;
        this.mode = mode;
        tik = 0;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (mode){
            case GameConstStr.GLOBAL:
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
                game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane().move();
                break;
            case GameConstStr.LOCAL:
                break;
        }
    }
}
