package view.gamewindows;

import control.GameController;
import model.BackGround;
import model.FlyingObject;
import model.Game;
import model.maingame.hero.HeroPlane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private final Game game;

    private final BackGround backGround;//背景
    private final ArrayList<FlyingObject> planeList;//飞行物集合
    private final ArrayList<FlyingObject> ammoList;//弹药集合
    private final ArrayList<FlyingObject> effectiveObjectList;//增益效果集合
    private final ArrayList<ArrayList<FlyingObject>> totalList;

    public GamePanel(Game game) {
        setLayout(null);
        planeList = new ArrayList<>();
        ammoList = new ArrayList<>();
        effectiveObjectList = new ArrayList<>();
        totalList = new ArrayList<>();
        totalList.add(planeList);
        totalList.add(ammoList);
        totalList.add(effectiveObjectList);
        this.game = game;
        backGround = game.getGameLevel().getBackGround();
        planeList.add(new HeroPlane(game));
    }

    public ArrayList<ArrayList<FlyingObject>> getTotalList() {
        return totalList;
    }

    public BackGround getBackGround() {
        return backGround;
    }

    public ArrayList<FlyingObject> getEffectiveObjectList() {
        return effectiveObjectList;
    }

    public ArrayList<FlyingObject> getPlaneList() {
        return planeList;
    }

    public ArrayList<FlyingObject> getAmmoList() {
        return ammoList;
    }

    /**
     * 返回英雄机
     *
     * @return 返回英雄机
     */
    public HeroPlane getHeroPlane() {
        return (HeroPlane) planeList.get(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        GameController.drawPane(g, this);
        repaint();
    }
}
