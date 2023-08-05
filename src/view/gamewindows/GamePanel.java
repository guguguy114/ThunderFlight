package view.gamewindows;

import control.GameConstDataUtil;
import control.GameController;
import model.BackGround;
import model.FlyingObject;
import model.Game;
import model.maingame.ammo.Ammo;
import model.maingame.hero.HeroPlane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GamePanel extends JPanel {
    private final Game game;
    private final BackGround backGround;
    private final ArrayList<FlyingObject> planeList;
    private ArrayList<FlyingObject> ammoList;

    public GamePanel(Game game) {
        setLayout(null);
        planeList = new ArrayList<>();
        ammoList = new ArrayList<>();
        this.game = game;
        backGround = game.getGameLevel().getBackGround1();
        planeList.add(new HeroPlane());
    }

    public ArrayList<FlyingObject> getPlaneList() {
        return planeList;
    }

    public ArrayList<FlyingObject> getAmmoList() {
        return ammoList;
    }

    public FlyingObject getHeroPlane() {
        return planeList.get(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backGround.getObjImg(), 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, backGround.getObjY(), backGround.getObjImg().getWidth(null), backGround.getObjImg().getWidth(null) + backGround.getObjY(), null);
        g.drawImage(backGround.getObjImg(), 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, backGround.getObjImg().getHeight(null) + backGround.getObjY(), backGround.getObjImg().getWidth(null), backGround.getObjImg().getWidth(null) + backGround.getObjImg().getHeight(null) + backGround.getObjY(), null);
        GameController.drawPane(g, this);
        repaint();
    }
}
