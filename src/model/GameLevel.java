package model;

public class GameLevel {
    private final int level;
    private BackGround backGround;
    private int promotedEnemyPlaneQuantity;
    private int commonEnemyPlaneQuantity;
    private int enemySpeedY;
    private int enemySpeedX;
    private int commonCount;
    private int promoteCount;
    private boolean randomSpeed;
    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity, int level) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        this.level = level;
        setSpeed();
        randomSpeed = false;
        commonCount = 0;
        promoteCount = 0;
    }

    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        level = 0;
        randomSpeed = true;
        commonCount = 0;
        promoteCount = 0;
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

    public int getCommonCount() {
        return commonCount;
    }

    public void setCommonCount(int commonCount) {
        this.commonCount = commonCount;
    }

    public int getPromoteCount() {
        return promoteCount;
    }

    public void setPromoteCount(int promoteCount) {
        this.promoteCount = promoteCount;
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

    public void setSpeed(){
        enemySpeedY = level;
        enemySpeedX = level;
    }
}
