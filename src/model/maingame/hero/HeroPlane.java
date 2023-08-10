package model.maingame.hero;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import control.timer.StateTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.ammo.Ammo;
import model.maingame.ammo.Bullet;
import view.gamewindows.GamePanel;

public class HeroPlane extends FlyingObject {
    public boolean isAtk;
    public String atkMode;
    public StateTimer stateTimer;

    public HeroPlane(Game game) {
        objImg = GameConstResourceUtil.HERO_DOWN;
        objX = GameConstDataUtil.INITIAL_HERO_X;
        objY = GameConstDataUtil.INITIAL_HERO_Y;
        objectWidth = GameConstDataUtil.HERO_WIDTH;
        objectHeight = GameConstDataUtil.HERO_HEIGHT;
        objectName = GameConstStr.HERO_NAME;
        atkMode = GameConstStr.COMMON_ATK_MODE;
        stateTimer = new StateTimer(game, this);
        attackTimer = new AttackTimer(game, this, GameConstStr.HERO_NAME);
        isAtk = false;
        speedX = 10;
        speedY = 10;
        life = GameConstDataUtil.DEFAULT_HERO_LIFE;
    }

    @Override
    public void move() {
        if (isUp && objY > 0) {
            objY -= speedY;
        }
        if (isDown && objY + GameConstDataUtil.HERO_HEIGHT < GameConstDataUtil.GAME_PANEL_HEIGHT + 10) {
            objY += speedY;
        }
        if (isLeft && objX > 0) {
            objX -= speedX;
        }
        if (isRight && objX + GameConstDataUtil.HERO_WIDTH < GameConstDataUtil.GAME_PANEL_WIDTH) {
            objX += speedX;
        }

        atkPointX = objX + objectWidth / 2;
        actPointY = objY;
    }
    @Override
    public void attack(Game game) {
        switch (atkMode){
            case GameConstStr.COMMON_ATK_MODE:
                if (isAtk) {
                    //System.out.println("attacking");
                    GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                    Ammo newAmmo = new Bullet(GameConstStr.FRIEND, this.atkPointX, this.actPointY);
                    gamePanel.getAmmoList().add(newAmmo);
                }
                break;
            case GameConstStr.DOUBLE_ATK_MODE:
                if (isAtk){
                    GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
                    gamePanel.getAmmoList().add(new Bullet(GameConstStr.FRIEND, (this.atkPointX + objX) / 2, this.actPointY));
                    gamePanel.getAmmoList().add(new Bullet(GameConstStr.FRIEND, (this.atkPointX + objX + objectWidth) / 2, this.actPointY));
                }
                break;
        }
    }

    @Override
    public void dead(Game game) {

    }

    @Override
    public void changeAnimation() {

    }

    @Override
    protected void setDeadImages() {

    }
}
