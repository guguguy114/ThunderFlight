package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstStr;
import control.timer.AnimationTimer;
import control.timer.DeadTimer;
import model.FlyingObject;
import model.Game;
import model.MiniMap;
import model.maingame.ammo.Ammo;
import view.gamewindows.GameInformationPanel;
import view.gamewindows.GamePanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * 敌机总类
 */
public abstract class EnemyPlane extends FlyingObject {
    protected final boolean randomSpeed;
    protected int score;
    protected Point point;
    public EnemyPlane(Image image, int x, int y, Game game) {
        randomSpeed = game.getGameLevel().isRandomSpeed();
        deadImgList = new ArrayList<>();
        className = GameConstStr.ENEMY_PLANE_NAME;
        img = image;
        objX = x;
        objY = y;
        animationList = new ArrayList<>();
        animationTimer = new AnimationTimer(game);
        setAnimation();
        point = new Point();
    }

    @Override
    public void dead(Game game) {
        if (hitBle){
            game.getPlayer().setScore(game.getPlayer().getScore() + score);
            stopFlyingObject();
        }
        hitBle = false;
        animationTimer.getTimer().stop();
        deadTimer = new DeadTimer(game, this);
        deadTimer.getTimer().start();
        attackTimer.getTimer().stop();
    }

    public abstract void hitFeedback(Game game);

    @Override
    protected void setAnimation() {

    }

    @Override
    public void hitDetect(Game game) {
        if (hitBle){
            GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
            for (ArrayList<FlyingObject> totalList : gamePanel.getTotalList()) {
                for (FlyingObject flyingObject : totalList) {
                    if (intersect(flyingObject)) {
                        if (flyingObject instanceof Ammo && ((Ammo) flyingObject).getBelongTo().equals(GameConstStr.FRIEND)) {
                            ((Ammo) flyingObject).hitFeedback(game, this);
                            if (life == 0) {
                                dead(game);
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void deadCount(Game game);

    @Override
    public void draw(Graphics g, Game game) {
        super.draw(g, game);
        drawInMap(game);
    }

    protected void drawInMap(Game game){
        GameInformationPanel gameInformationPanel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        MiniMap miniMap = gameInformationPanel.miniMap;
        int x = (int) (miniMap.getObjX() + ((double)(objX + width / 2) / (double)GameConstDataUtil.GAME_PANEL_WIDTH) * miniMap.getWidth());
        int y = (int) (miniMap.getObjY() + ((double)(objY + height / 2) / (double)GameConstDataUtil.GAME_PANEL_HEIGHT) * miniMap.getHeight());
        point.setPos(x, y);
        Graphics g = gameInformationPanel.getGraphics();
        point.draw(g, game);// 2023/9/4 这里绘制小地图
    }
}
