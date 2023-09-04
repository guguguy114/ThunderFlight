package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;
import model.GameLevel;
import model.Music;
import model.maingame.ammo.Bullet;
import view.gamewindows.GameInformationPanel;
import view.gamewindows.GamePanel;

import java.util.Random;

public class EnemyBoss extends EnemyPlane{

    private String motionMode;
    private int leftCount;
    private int rightCount;
    private int key;


    public EnemyBoss(int x, int y, Game game) {
        super(GameConstResourceUtil.BOSS_1, x, y, game);
        GameLevel gameLevel = game.getGameLevel();
        width = GameConstDataUtil.BOSS_WIDTH;
        height = GameConstDataUtil.BOSS_HEIGHT;
        speedX = gameLevel.getEnemySpeedX() + 1;
        speedY = gameLevel.getEnemySpeedY();
        motionMode = GameConstStr.BOSS_MOVE_STAGE_DOWN;
        life = game.getGameLevel().getBossLife();
        score = life;
        down = true;
        gameLevel.setBossSummonCount(gameLevel.getBossSummonCount() + 1);
        attackTimer = new AttackTimer(game, this, GameConstStr.ENEMY_BOSS);
        attackTimer.getTimer().start();
        animationTimer.getTimer().start();
        System.out.println("creating_boss");
        System.out.println("middle is " + (GameConstDataUtil.GAME_PANEL_WIDTH - width) / 2);
        key = 0;
    }

    @Override
    public void move(Game game) {
        GameInformationPanel gameInformationPanel = game.getUi().getGameWin().getGameMainPanel().getGameInformationPanel();
        gameInformationPanel.debug.setText(String.valueOf(life));
        gameInformationPanel.debug2.setText(motionMode);
        //System.out.println("currentX:" + objX);




        if (objX + width >= GameConstDataUtil.GAME_PANEL_WIDTH){
            rightCount ++;
            right = false;
            left = true;
        }
        if (objX <= 0){
            leftCount ++;
            left = false;
            right = true;
        }





        if (right){
            objX += speedX;
        }
        if (left){
            objX -= speedX;
        }
        if (down){
            objY += speedY;
        }


        if (objY + height >= GameConstDataUtil.GAME_PANEL_HEIGHT / 3 && !motionMode.equals(GameConstStr.BOSS_MOVE_STAGE_LEFT_RIGHT_AROUND) && key == 0){
            key = 1;
            down = false;
            Random r = new Random();
            int key = r.nextInt(2);
            if (key == 0){
                right = true;
                left = false;
            }
            if (key == 1){
                right = false;
                left = true;
            }
            motionMode = GameConstStr.BOSS_MOVE_STAGE_LEFT_RIGHT_AROUND;
        }

        if (leftCount == 3 || rightCount == 3 && key == 1){
            //System.out.println("3");
            motionMode = GameConstStr.BOSS_MOVE_STAGE_DOWN;
        }

        if (motionMode.equals(GameConstStr.BOSS_MOVE_STAGE_DOWN) && objX == (GameConstDataUtil.GAME_PANEL_WIDTH - width) / 2 && key == 1){
            //System.out.println("m");
            down = true;
            left = false;
            right = false;
            if (objY == (GameConstDataUtil.GAME_PANEL_HEIGHT - height) / 2){
                motionMode = GameConstStr.BOOS_MOVE_STAGE_STOP_IN_MIDDLE;
                down = false;
                key = 1000;
            }
        }

        if (motionMode.equals(GameConstStr.BOOS_MOVE_STAGE_STOP_IN_MIDDLE)){
            key++;
            if (key == 2000){
                down = true;
                motionMode = GameConstStr.BOSS_MOVE_STAGE_DOWN;
            }
        }

        atkPointX = objX + width / 2;
        actPointY = objY + height / 2;

    }

    @Override
    public void attack(Game game) {
        Music fire = new Music(Music.FIRE);
        fire.startMusic();
        //System.out.println("boss_shoot");
        GamePanel gamePanel = game.getUi().getGameWin().getGameMainPanel().getGamePanel();
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_UP));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_UP_AND_RIGHT));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_RIGHT));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_DOWN_AND_RIGHT));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_DOWN));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_DOWN_AND_LEFT));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_LEFT));
        gamePanel.getAmmoList().add(new Bullet(GameConstStr.ENEMY, atkPointX, actPointY, this, GameConstDataUtil.DIRECT_UP_AND_LEFT));
    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        game.getGameLevel().setBossDead(true);
        deadCount(game);
    }

    @Override
    public void hitFeedback(Game game) {

    }

    @Override
    protected void setAnimation() {
        super.setAnimation();
        animationList.add(GameConstResourceUtil.BOSS_1);
        animationList.add(GameConstResourceUtil.BOSS_2);
        animationList.add(GameConstResourceUtil.BOSS_3);
        animationList.add(GameConstResourceUtil.BOSS_4);
        animationList.add(GameConstResourceUtil.BOSS_5);
    }

    @Override
    public void deadCount(Game game) {
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.setBossDeadCount(gameLevel.getBossDeadCount() + 1);
    }

    @Override
    public void changeAnimation() {
        if (animationOrder < animationList.size() - 1){
            animationOrder++;
            img = animationList.get(animationOrder);
        }else {
            animationOrder = 0;
        }
    }

    @Override
    protected void setDeadImages() {

    }
}
