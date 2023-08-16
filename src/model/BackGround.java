package model;

import control.GameConstDataUtil;

import java.awt.*;

/**
 * 背景
 */
public class BackGround extends FlyingObject {
    public BackGround(Image image) {
        this.img = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, objY, img.getWidth(null), img.getWidth(null) + objY, null);
        g.drawImage(img, 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, img.getHeight(null) + objY, img.getWidth(null), img.getWidth(null) + img.getHeight(null) + objY, null);
    }

    @Override
    public void move(Game game) {

    }
    @Override
    public void attack(Game game) {

    }
    @Override
    public void dead(Game game) {

    }
    @Override
    public void changeAnimation() {

    }

    @Override
    public void hitDetect(Game game) {

    }

    @Override
    protected void setDeadImages() {

    }
}
