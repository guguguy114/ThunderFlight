package model;

public class GameLevel {
    private BackGround backGround;
    private int promotedEnemyPlaneQuantity;
    private int commonEnemyPlaneQuantity;
    private int enemySpeedY;
    private int enemySpeedX;
    private int commonCount;
    private int promoteCount;
    private boolean randomSpeed;
    private String level;

    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity, String level) {
        this.backGround = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
        this.level = level;
    }

    public String getLevel() {
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
}
