package model;

/**
 * 游戏关卡
 */
public class GameLevel {
    private final int level;
    private BackGround backGround;
    private int promotedEnemyPlaneQuantity;
    private int commonEnemyPlaneQuantity;
    private int bossQuantity;
    private int enemySpeedY;
    private int enemySpeedX;
    private int commonSummonCount;
    private int promoteSummonCount;
    private int bossSummonCount;
    private boolean randomSpeed;
    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity, int level) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        this.level = level;
        setSpeed();
        randomSpeed = false;
        commonSummonCount = 0;
        promoteSummonCount = 0;
    }
    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        level = 0;
        randomSpeed = true;
        commonSummonCount = 0;
        promoteSummonCount = 0;
    }

    public int getBossQuantity() {
        return bossQuantity;
    }

    public void setBossQuantity(int bossQuantity) {
        this.bossQuantity = bossQuantity;
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

    public void setEnemySpeedY(int enemySpeedY) {
        this.enemySpeedY = enemySpeedY;
    }

    public int getEnemySpeedX() {
        return enemySpeedX;
    }

    public void setEnemySpeedX(int enemySpeedX) {
        this.enemySpeedX = enemySpeedX;
    }

    public boolean isRandomSpeed() {
        return randomSpeed;
    }

    public void setRandomSpeed(boolean randomSpeed) {
        this.randomSpeed = randomSpeed;
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

    public int getLevel() {
        return level;
    }

    public BackGround getBackGround() {
        return backGround;
    }

    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

    public int getPromotedEnemyPlaneQuantity() {
        return promotedEnemyPlaneQuantity;
    }

    public void setPromotedEnemyPlaneQuantity(int promotedEnemyPlaneQuantity) {
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
    }

    public int getCommonEnemyPlaneQuantity() {
        return commonEnemyPlaneQuantity;
    }

    public void setCommonEnemyPlaneQuantity(int commonEnemyPlaneQuantity) {
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
    }

    public void setSpeed() {
        enemySpeedY = level;
        enemySpeedX = level;
    }
}
