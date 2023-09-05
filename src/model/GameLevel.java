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
    private final boolean randomSpeed;
    private final int bossQuantity;
    private int enemySpeedY;
    private int enemySpeedX;
    private int commonSummonCount;
    private int promoteSummonCount;
    private int bossSummonCount;
    private int commonDeadCount;
    private int promoteDeadCount;
    private int bossDeadCount;
    private int speed;
    private final String levelName;
    private final int bossLife;
    private final int levelID;
    private int passLineEnemyQuantity;
    private boolean bossDead;
    private final Music BGM;

    public GameLevel(String backgroundName, String levelName, int levelSpeed, int commonNum, int promoteNum, int bossLife, int levelID) {
        backGround = new BackGround(chooseBG(backgroundName));
        commonEnemyPlaneQuantity = commonNum;
        promotedEnemyPlaneQuantity = promoteNum;
        bossQuantity = 1;
        this.bossLife = bossLife;
        this.levelName = levelName;
        this.levelID = levelID;
        randomSpeed = false;
        BGM = new Music(Music.MAIN_GAME_BGM_1, GameConstStr.MUSIC_BGM);
        setSpeed(levelSpeed);
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

    public void setSpeed(int levelSpeed) {
        speed = levelSpeed;
        enemySpeedX = levelSpeed;
        enemySpeedY = levelSpeed;
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
    public boolean isBossDead() {
        return bossDead;
    }

    public void setBossDead(boolean bossDead) {
        this.bossDead = bossDead;
    }

    public int getEnemySpeedX() {
        return enemySpeedX;
    }

    public Music getBGM() {
        return BGM;
    }
}
