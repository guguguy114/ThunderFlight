package model.maingame.effectiveobject;

import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameUIController;
import model.BigBomb;
import model.FlyingObject;
import model.Game;
import model.Music;
import model.maingame.enemy.EnemyBoss;
import model.maingame.enemy.EnemyPlane;
import model.maingame.hero.HeroPlane;
import view.gamewindows.GamePanel;

import java.util.ArrayList;

public class NuclearWeapon extends EffectiveObject{


    public NuclearWeapon(Game game, int x, int y) {
        super(game, x, y);
        img = GameConstResourceUtil.NUCLEAR_BOMB;
        width = img.getWidth(null);
        height = img.getHeight(null);
        hitMusic = new Music(Music.GET_BOMB, GameConstStr.MUSIC_EQ);
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    protected void setDeadImages() {

    }

    @Override
    public void hitFeedback() {
        HeroPlane heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        if (heroPlane.getNuclearNum() < 2){
            heroPlane.setNuclearNum(heroPlane.getNuclearNum() + 1);
        }
        GameUIController.refreshInfoPanel(game);
    }

    public static void boom(Game game){
        HeroPlane heroPlane = game.getUi().getGameWin().getGameMainPanel().getGamePanel().getHeroPlane();
        if (heroPlane.getNuclearNum() >= 1){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            BigBomb bomb = new BigBomb(game);
            gamePanel.getPlaneList().add(bomb);
            for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()){
                for (FlyingObject flyingObject : totalList){
                    if (flyingObject instanceof EnemyPlane && !(flyingObject instanceof EnemyBoss)){
                        flyingObject.dead(game);
                    }
                }
            }
            heroPlane.setNuclearNum(heroPlane.getNuclearNum() - 1);
        }else {
            System.out.println("fail_to_use_nuclear_weapon");
        }
    }
}
