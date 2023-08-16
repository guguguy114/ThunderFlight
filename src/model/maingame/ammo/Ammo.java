package model.maingame.ammo;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;

import java.util.ArrayList;

/**
 * 弹药总类
 */
public abstract class Ammo extends FlyingObject {
    protected int damage;//弹药伤害
    protected String belongTo;//所属阵营

    public Ammo(String belongTo, int x, int y) {
        this.belongTo = belongTo;
        objX = x;
        objY = y;
        className = GameConstStr.AMMO_NAME;
        deadImgList = new ArrayList<>();
        setDeadImages();
    }

    public String getBelongTo() {
        return belongTo;
    }

    @Override
    public void move(Game game) {
        if (out){
            dead(game);
        }
    }

    /**
     * 击中效果
     * @param game 游戏对象
     * @param objIn 击中的对象
     */
    public void hitFeedback(Game game, FlyingObject objIn) {
        if (!out) {
            objIn.setLife(objIn.getLife() - damage);
            out = true;
            width = img.getHeight(null);
        }
    }

    @Override
    public void dead(Game game) {
        hitBle = false;
        stopFlyingObject();
    }

    @Override
    public void hitDetect(Game game) {

    }
}
