package model;

import control.GameConstDataUtil;
import control.timer.AttackTimer;
import control.timer.DeadTimer;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FlyingObject {
    public boolean isUp, isDown, isLeft, isRight, isOut = false;
    protected int objX, objY, atkPointX, actPointY, speedX, speedY;
    protected int objectWidth, objectHeight;
    protected Image objImg;
    protected int life;
    protected DeadTimer deadTimer;
    protected List<Image> animationList;
    protected String objectName;
    protected int animationOrder = 0;
    protected AttackTimer attackTimer;
    protected ArrayList<Image> deadImgList;
    protected String atkMode;
    protected boolean hitBal = true;

    public boolean isHitBal() {
        return hitBal;
    }

    public DeadTimer getDeadTimer() {
        return deadTimer;
    }

    public ArrayList<Image> getDeadImgList() {
        return deadImgList;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public String getObjectName() {
        return objectName;
    }

    public int getObjectWidth() {
        return objectWidth;
    }

    public int getObjectHeight() {
        return objectHeight;
    }

    public abstract void move();

    public abstract void attack(Game game);

    public abstract void dead(Game game);

    public Image getObjImg() {
        return objImg;
    }

    public void setObjImg(Image objImg) {
        this.objImg = objImg;
    }

    public int getObjX() {
        return objX;
    }

    public void setObjX(int objX) {
        this.objX = objX;
    }

    public int getObjY() {
        return objY;
    }

    public void setObjY(int objY) {
        this.objY = objY;
    }

    public void stopFlyingObject() {
        isLeft = false;
        isRight = false;
        isUp = false;
        isDown = false;
    }

    public AttackTimer getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(AttackTimer attackTimer) {
        this.attackTimer = attackTimer;
    }

    public void draw(Graphics g) {
        //System.out.println("drawing_" + this.getClass());
        g.drawImage(objImg, objX, objY, objectWidth, objectHeight, null);
    }

    public boolean isDisappear(GamePanel gamePanel) {
        return objX <= -GameConstDataUtil.BORDER || objX >= gamePanel.getWidth() + GameConstDataUtil.BORDER || objY <= -GameConstDataUtil.BORDER || objY >= gamePanel.getHeight() + GameConstDataUtil.BORDER;
    }

    public abstract void changeAnimation();

    protected void finalize() {
        //System.out.println("removed " + getClass());
    }

    protected abstract void setDeadImages();
}
