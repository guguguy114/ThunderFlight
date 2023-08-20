package model.maingame.ammo;

import control.GameConstStr;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import view.gamewindows.GamePanel;

import java.util.ArrayList;

/**
 * 弹药总类
 */
public abstract class Ammo extends FlyingObject {
    protected int deadLength;
    @Override
    protected void setAnimation() {

    }

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
            width = img.getHeight(null);
            dead(game);
        }
    }

    @Override
    public void dead(Game game) {
        deadLength = height;
        width = deadLength;
        hitBle = false;
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
        stopFlyingObject();
    }

    @Override
    public void hitDetect(Game game) {
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()){
            for (FlyingObject flyingObject : totalList){
                if (intersect(flyingObject)){
                    if (flyingObject instanceof Ammo && flyingObject != this && flyingObject.isHitBle() && this.hitBle){
                        flyingObject.dead(game);
                        this.hitBle = false;
                        this.dead(game);
                    }
                }
            }
        }
    }
}
