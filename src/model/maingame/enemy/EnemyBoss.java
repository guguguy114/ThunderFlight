package model.maingame.enemy;

import control.GameConstDataUtil;
import control.GameConstResourceUtil;
import control.GameConstStr;
import control.timer.AttackTimer;
import model.Game;
import model.GameLevel;

import java.util.Random;

public class EnemyBoss extends EnemyPlane{

    private String motionMode;
    private int leftCount;
    private int rightCount;


    public EnemyBoss(int x, int y, Game game) {
        super(GameConstResourceUtil.BOSS_1, x, y, game);
        GameLevel gameLevel = game.getGameLevel();
        width = GameConstDataUtil.BOSS_WIDTH;
        height = GameConstDataUtil.BOSS_HEIGHT;
        speedX = 2;
        speedY = 1;
        motionMode = GameConstStr.BOSS_MOVE_STAGE_DOWN;
        life = game.getGameLevel().getBossLife();
        score = life;
        down = true;
        gameLevel.setBossSummonCount(gameLevel.getBossSummonCount() + 1);
        attackTimer = new AttackTimer(game, this, GameConstStr.ENEMY_BOSS);
        animationTimer.getTimer().start();
        System.out.println("creating_boss");
    }

    @Override
    public void move(Game game) {
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


        if (objY + height >= GameConstDataUtil.GAME_PANEL_HEIGHT / 3 && !motionMode.equals(GameConstStr.BOSS_MOVE_STAGE_LEFT_RIGHT_AROUND)){
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

        if (leftCount == 3 || rightCount == 3){
            left = false;
            right = false;
            motionMode = GameConstStr.BOSS_MOVE_STAGE_DOWN;
        }
    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {
        super.dead(game);
        GameLevel gameLevel = game.getGameLevel();
        gameLevel.setBossDeadCount(gameLevel.getBossDeadCount() + 1);

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
