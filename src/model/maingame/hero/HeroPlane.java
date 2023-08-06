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

import java.util.ArrayList;

public class HeroPlane extends FlyingObject {
    private ArrayList<Ammo> AmmoList;
    public boolean isAtk;

    public HeroPlane(Game game) {
        objImg = GameConstResourceUtil.HERO_DOWN;
        objX = GameConstDataUtil.INITIAL_HERO_X;
        objY = GameConstDataUtil.INITIAL_HERO_Y;
        objectWidth = GameConstDataUtil.HERO_WIDTH;
        objectHeight = GameConstDataUtil.HERO_HEIGHT;
        objectName = GameConstStr.PLANE_NAME;
        attackTimer = new AttackTimer(game, this);
        isAtk = false;
    }

    @Override
    public void move() {
        if (isUp && objY > 0) {
            objY -= GameConstDataUtil.HERO_STEP_LENGTH;
        }
        if (isDown && objY + GameConstDataUtil.HERO_HEIGHT < GameConstDataUtil.GAME_PANEL_HEIGHT + 10) {
            objY += GameConstDataUtil.HERO_STEP_LENGTH;
        }
        if (isLeft && objX > 0) {
            objX -= GameConstDataUtil.HERO_STEP_LENGTH;
        }
        if (isRight && objX + GameConstDataUtil.HERO_WIDTH < GameConstDataUtil.GAME_PANEL_WIDTH) {
            objX += GameConstDataUtil.HERO_STEP_LENGTH;
        }

        atkPointX = objX + objectWidth / 2;
        actPointY = objY;
    }
    @Override
    public void attack(Game game) {
        if (isAtk){
            //System.out.println("attacking");
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            Ammo newAmmo = new Bullet(GameConstStr.FRIENDLY, this.atkPointX, this.actPointY);
            gamePanel.getAmmoList().add(newAmmo);
            isAtk = false;
        }
    }

    @Override
    public void changeAnimation() {

    }
}
