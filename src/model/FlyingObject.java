package model;

import control.GameConstDataUtil;
import control.timer.AnimationTimer;
import control.timer.AttackTimer;
import control.timer.DeadTimer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 飞行物总类
 */
public abstract class FlyingObject {
    public boolean up, down, left, right, out = false;
    protected int objX, objY, atkPointX, actPointY, speedX, speedY;
    protected int width, height;
    protected Image img;
    protected int life;
    protected DeadTimer deadTimer;
    protected List<Image> animationList;
    protected String objectName;
    protected int animationOrder;
    protected AnimationTimer animationTimer;
    protected AttackTimer attackTimer;
    protected ArrayList<Image> deadImgList;
    //protected String atkMode;
    protected boolean hitBle = true;
    protected String className;


    /**
     * 绘制对象
     *
     * @param g    对应页面的绘画工具
     * @param game 所在的游戏对象
     */
    public void draw(Graphics g, Game game) {
        //System.out.println("drawing_" + this.getClass());
        g.drawImage(img, objX, objY, width, height, null);
    }

    /**
     * 判断是否飞行物出界
     * @return 返回布尔值
     */
    public boolean isDisappear() {
        return objY >= GameConstDataUtil.GAME_PANEL_HEIGHT + GameConstDataUtil.BORDER ;
    }

    /**
     * 使其停止运行
     */
    public void stopFlyingObject() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    /**
     * 对象移动方法
     */
    public abstract void move(Game game);

    /**
     * 对象攻击方法
     * @param game 游戏对象
     */

    public abstract void attack(Game game);

    /**
     * 对象死亡时所触发的事件
     * @param game 游戏对象
     */
    public abstract void dead(Game game);

    /**
     * 对象切换动画的方法
     */
    public abstract void changeAnimation();

    public abstract void hitDetect(Game game);

    protected abstract void setDeadImages();

    protected boolean intersect(FlyingObject objIn){
        Rectangle thisRect = new Rectangle(objX, objY, width, height);
        Rectangle objInRect = new Rectangle(objIn.objX, objIn.objY, objIn.width, objIn.height);
        return thisRect.intersects(objInRect);
    }

    protected abstract void setAnimation();














    public boolean isHitBle() {
        return hitBle;
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

    public int getSpeedY() {
        return speedY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
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
    public AttackTimer getAttackTimer() {
        return attackTimer;
    }
    protected void finalize() {
        //System.out.println("removed " + getClass());
    }

    public int getSpeedX() {
        return speedX;
    }
}
