package model;

import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.List;

public abstract class FlyingObject {
    public boolean isUp, isDown, isLeft, isRight;
    protected int objX, objY;
    protected Image objImg;
    protected List<Image> animationList;
    protected int speedX;
    protected int speedY;
    protected int atkPointX;
    protected int actPointY;
    protected int objectWidth;
    protected int objectHeight;
    protected String objectName;
    protected int animationOrder = 0;

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

    public void draw(Graphics g) {
        //System.out.println("drawing_" + this.getClass());
        g.drawImage(objImg, objX, objY, objectWidth, objectHeight, null);
    }

    public boolean isDisappear(GamePanel gamePanel) {
        return objX <= -50 || objX >= gamePanel.getWidth() + 50 || objY <= -50 || objY >= gamePanel.getHeight() + 50;
    }

    public abstract void changeAnimation();
}
