package view.gamewindows;

import control.GameConstDataUtil;
import model.BackGround;
import model.Game;
import model.maingame.hero.HeroPlane;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Game game;
    private final BackGround backGround;
    private final HeroPlane heroPlane;

    public GamePanel(Game game) {

        setLayout(null);
        this.game = game;
        backGround = game.getGameLevel().getBackGround1();
        heroPlane = new HeroPlane();
    }

    public HeroPlane getHeroPlane() {
        return heroPlane;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backGround.getObjImg(), 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, backGround.getObjY(), 480, 480 + backGround.getObjY(), null);
        g.drawImage(backGround.getObjImg(), 0, 0, GameConstDataUtil.GAME_PANEL_WIDTH, GameConstDataUtil.GAME_PANEL_HEIGHT, 0, 800 + backGround.getObjY(), 480, 1280 + backGround.getObjY(), null);
        g.drawImage(heroPlane.getObjImg(), heroPlane.getObjX(), heroPlane.getObjY(), 50, 50, null);
        repaint();
    }
}
