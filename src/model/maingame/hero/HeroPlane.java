package model.maingame.hero;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.GameController;
import control.timer.AttackTimer;
import control.timer.StateTimer;
import model.FlyingObject;
import model.Game;
import model.Music;
import model.maingame.ammo.Ammo;
import model.maingame.ammo.Bullet;
import model.maingame.effectiveobject.EffectiveObject;
import model.maingame.effectiveobject.NuclearWeapon;
import model.maingame.enemy.EnemyBoss;
import model.maingame.enemy.EnemyPlane;
import view.gamewindows.GamePanel;

import java.util.ArrayList;

/**
 * 英雄机
 */
public class HeroPlane extends FlyingObject {
    public boolean isAtk;
    public String atkMode;
    public StateTimer stateTimer;
    private int nuclearNum;

    public HeroPlane(Game game) {
        img = GameConstResourceUtil.HERO_DOWN;
        objX = GameConstDataUtil.INITIAL_HERO_X;
        objY = GameConstDataUtil.INITIAL_HERO_Y;
        width = GameConstDataUtil.HERO_WIDTH;
        height = GameConstDataUtil.HERO_HEIGHT;
        className = GameConstStr.HERO_NAME;
        objectName = GameConstStr.HERO_NAME;
        atkMode = GameConstStr.COMMON_ATK_MODE;
        stateTimer = new StateTimer(game, this);
        attackTimer = new AttackTimer(game, this, GameConstStr.HERO_NAME);
        isAtk = false;
        speedX = 10;
        speedY = 10;
        life = GameConstDataUtil.DEFAULT_HERO_LIFE;
    }

    public HeroPlane(Game game, int life) {
        this(game);
        this.life = life;
    }

    @Override
    public void move(Game game) {
        if (up && objY > 0) {
            objY -= speedY;
        }
        if (down && objY + GameConstDataUtil.HERO_HEIGHT < GameConstDataUtil.GAME_PANEL_HEIGHT + 10) {
            objY += speedY;
        }
        if (left && objX > 0) {
            objX -= speedX;
        }
        if (right && objX + GameConstDataUtil.HERO_WIDTH < GameConstDataUtil.GAME_PANEL_WIDTH) {
            objX += speedX;
        }

        atkPointX = objX + width / 2;
        actPointY = objY;
    }

    @Override
    public void attack(Game game) {

        switch (atkMode) {
            case GameConstStr.COMMON_ATK_MODE:
                if (isAtk) {
                    Music fire = new Music(Music.FIRE, GameConstStr.MUSIC_EQ);
                    fire.startMusic();
                    //System.out.println("attacking");
                    GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                    Ammo newAmmo = new Bullet(GameConstStr.FRIEND, this.atkPointX, this.actPointY, GameConstDataUtil.DIRECT_UP);
                    gamePanel.getAmmoList().add(newAmmo);
                }
                break;
            case GameConstStr.DOUBLE_ATK_MODE:
                if (isAtk) {
                    Music fire = new Music(Music.FIRE, GameConstStr.MUSIC_EQ);
                    fire.startMusic();
                    GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                    gamePanel.getAmmoList().add(new Bullet(GameConstStr.FRIEND, (this.atkPointX + objX) / 2, this.actPointY, GameConstDataUtil.DIRECT_UP));
                    gamePanel.getAmmoList().add(new Bullet(GameConstStr.FRIEND, (this.atkPointX + objX + width) / 2, this.actPointY, GameConstDataUtil.DIRECT_UP));
                }
                break;
        }
    }

    @Override
    public void dead(Game game) {
        Music dead = new Music(Music.REBORN, GameConstStr.MUSIC_EQ);
        dead.startMusic();
        objX = GameConstDataUtil.INITIAL_HERO_X;
        objY = GameConstDataUtil.INITIAL_HERO_Y;
        atkMode = GameConstStr.COMMON_ATK_MODE;
        NuclearWeapon.boom(game);
        nuclearNum = 0;
        out = false;
    }

    @Override
    public void changeAnimation() {

    }

    @Override
    public void hitDetect(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()) {
            for (FlyingObject flyingObject : totalList) {
                if (intersect(flyingObject)) {
                    if (flyingObject instanceof EffectiveObject) {
                        if (flyingObject.isHitBle()) {
                            ((EffectiveObject) flyingObject).hitFeedback();
                            flyingObject.dead(game);
                        }
                    }
                    if (flyingObject instanceof Ammo && ((Ammo) flyingObject).getBelongTo().equals(GameConstStr.ENEMY)) {
                        if (flyingObject.isHitBle()) {
                            ((Ammo) flyingObject).hitFeedback(game, this);
                            flyingObject.dead(game);
                        }
                    }
                    if (flyingObject instanceof EnemyPlane) {
                        if (flyingObject.isHitBle()) {
                            if (!(flyingObject instanceof EnemyBoss)){
                                ((EnemyPlane) flyingObject).hitFeedback(game);
                                out = true;
                                flyingObject.dead(game);
                            }else {
                                GameController.fail(game);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void setDeadImages() {

    }

    @Override
    protected void setAnimation() {

    }























    public int getNuclearNum() {
        return nuclearNum;
    }

    public void setNuclearNum(int nuclearNum) {
        this.nuclearNum = nuclearNum;
    }
}
