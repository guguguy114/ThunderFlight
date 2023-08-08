package model.maingame.hero;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.FlyingObject;
import model.Game;
import model.maingame.ammo.Ammo;
import model.maingame.ammo.Bullet;
import view.gamewindows.GamePanel;

public class HeroPlane extends FlyingObject {
    public boolean isAtk;
    public String atkMode;

    public HeroPlane(Game game) {
        objImg = GameConstResourceUtil.HERO_DOWN;
        objX = GameConstDataUtil.INITIAL_HERO_X;
        objY = GameConstDataUtil.INITIAL_HERO_Y;
        objectWidth = GameConstDataUtil.HERO_WIDTH;
        objectHeight = GameConstDataUtil.HERO_HEIGHT;
        objectName = GameConstStr.HERO_NAME;
        attackTimer = new AttackTimer(game, this);
        isAtk = false;
        speedX = 10;
        speedY = 10;
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
        if (isAtk){
            //System.out.println("attacking");
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            Ammo newAmmo = new Bullet(GameConstStr.FRIEND, this.atkPointX, this.actPointY);
            gamePanel.getAmmoList().add(newAmmo);
            isAtk = false;
        }
    }

    @Override
    public void changeAnimation() {

    }
}
