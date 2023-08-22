package model;

import control.GameConstResourceUtil;
import control.GameConstStr;

import java.awt.*;

/**
 * 游戏关卡
 */
public class GameLevel {
    private final BackGround backGround;
    private final int promotedEnemyPlaneQuantity;
    private final int commonEnemyPlaneQuantity;
    private int bossQuantity;
    private int enemySpeedY;
    private int enemySpeedX;
    private int commonSummonCount;
    private int promoteSummonCount;
    private int bossSummonCount;
    private int commonDeadCount;
    private int promoteDeadCount;
    private int bossDeadCount;
    private final boolean randomSpeed;
    private int speed;
    private String levelName;
    private int bossLife;

    private int levelID;
    private int passLineEnemyQuantity;



    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity, int bossQuantity) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        this.bossQuantity = bossQuantity;
        speed = 1;
        enemySpeedY = speed;
        enemySpeedX = speed;
        randomSpeed = false;
    }

    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        randomSpeed = true;
    }

    public GameLevel(String backgroundName, String levelName, int levelSpeed, int commonNum, int promoteNum, int bossLife, int levelID) {
        backGround = new BackGround(chooseBG(backgroundName));
        commonEnemyPlaneQuantity = commonNum;
        promotedEnemyPlaneQuantity = promoteNum;
        bossQuantity = 1;
        speed = levelSpeed;
        this.bossLife = bossLife;
        this.levelName = levelName;
        this.levelID = levelID;
        randomSpeed = false;
        setSpeed();
    }



    public boolean isComplete() {
        return bossDeadCount == bossQuantity && commonDeadCount == commonEnemyPlaneQuantity && promoteDeadCount == promotedEnemyPlaneQuantity;
    }

    private Image chooseBG(String bgName) {
        switch (bgName) {
            case GameConstStr.BG1:
                return GameConstResourceUtil.BG1;
            case GameConstStr.BG2:
                return GameConstResourceUtil.BG2;
            case GameConstStr.BG3:
                return GameConstResourceUtil.BG3;
            default:
                return null;
        }
    }

    private void setSpeed(){
        enemySpeedX = speed;
        enemySpeedY = speed;
    }






















    public int getCommonDeadCount() {
        return commonDeadCount;
    }

    public void setCommonDeadCount(int commonDeadCount) {
        this.commonDeadCount = commonDeadCount;
    }

    public int getPromoteDeadCount() {
        return promoteDeadCount;
    }

    public void setPromoteDeadCount(int promoteDeadCount) {
        this.promoteDeadCount = promoteDeadCount;
    }

    public int getBossDeadCount() {
        return bossDeadCount;
    }

    public void setBossDeadCount(int bossDeadCount) {
        this.bossDeadCount = bossDeadCount;
    }

    public int getBossQuantity() {
        return bossQuantity;
    }

    public int getBossSummonCount() {
        return bossSummonCount;
    }

    public void setBossSummonCount(int bossSummonCount) {
        this.bossSummonCount = bossSummonCount;
    }

    public int getEnemySpeedY() {
        return enemySpeedY;
    }

    public boolean isRandomSpeed() {
        return randomSpeed;
    }

    public int getCommonSummonCount() {
        return commonSummonCount;
    }

    public void setCommonSummonCount(int commonSummonCount) {
        this.commonSummonCount = commonSummonCount;
    }

    public int getPromoteSummonCount() {
        return promoteSummonCount;
    }

    public void setPromoteSummonCount(int promoteSummonCount) {
        this.promoteSummonCount = promoteSummonCount;
    }

    public BackGround getBackGround() {
        return backGround;
    }

    public int getPromotedEnemyPlaneQuantity() {
        return promotedEnemyPlaneQuantity;
    }

    public int getCommonEnemyPlaneQuantity() {
        return commonEnemyPlaneQuantity;
    }

    public int getSpeed() {
        return speed;
    }

    public String getLevelName() {
        return levelName;
    }
    public int getLevelID() {
        return levelID;
    }

    public int getBossLife() {
        return bossLife;
    }

    public int getPassLineEnemyQuantity() {
        return passLineEnemyQuantity;
    }

    public void setPassLineEnemyQuantity(int passLineEnemyQuantity) {
        this.passLineEnemyQuantity = passLineEnemyQuantity;
    }
}
