package view.gamewindows;

import control.GameConstDataUtil;
import control.GameController;
import control.GameUIController;
import model.BackGround;
import model.FlyingObject;
import model.Game;
import model.maingame.hero.HeroPlane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private final Game game;
    private BackGround backGround;//背景



    private ArrayList<FlyingObject> planeList;//飞行物集合
    private ArrayList<FlyingObject> ammoList;//弹药集合
    private ArrayList<FlyingObject> effectiveObjectList;//增益效果集合
    private ArrayList<ArrayList<FlyingObject>> totalList;

    public GamePanel(Game game) {
        setLayout(null);
        planeList = new ArrayList<>();
        ammoList = new ArrayList<>();
        effectiveObjectList = new ArrayList<>();
        setTotalList();
        this.game = game;
        backGround = game.getGameLevel().getBackGround();
        planeList.add(new HeroPlane(game));
    }


    @Override
    protected void paintComponent(Graphics g) {
        GameController.drawPane(g, this, game);
        Image screen = GameUIController.stateScreen(game);
        if (screen != null) {
            g.drawImage(screen, 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, (screen.getHeight(null) - screen.getWidth(null)) / 2, screen.getWidth(null), (screen.getHeight(null) + screen.getWidth(null)) / 2, null);
        }
        repaint();
    }

    /**
     * 返回英雄机
     *
     * @return 返回英雄机
     */
    public HeroPlane getHeroPlane() {
        return (HeroPlane) planeList.get(0);
    }

    public void setTotalList(){
        totalList = new ArrayList<>();
        totalList.add(planeList);
        totalList.add(ammoList);
        totalList.add(effectiveObjectList);
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

    public void setPlaneList(ArrayList<FlyingObject> planeList) {
        this.planeList = planeList;
    }

    public void setAmmoList(ArrayList<FlyingObject> ammoList) {
        this.ammoList = ammoList;
    }

    public void setEffectiveObjectList(ArrayList<FlyingObject> effectiveObjectList) {
        this.effectiveObjectList = effectiveObjectList;
    }

    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

}
