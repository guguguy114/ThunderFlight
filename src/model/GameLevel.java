package model;

public class GameLevel {
    private BackGround backGround1;
    private int promotedEnemyPlaneQuantity;
    private int commonEnemyPlaneQuantity;
    private int commonCount;
    private int promoteCount;

    public GameLevel(BackGround backGround, int promotedEnemyPlaneQuantity, int commonEnemyPlaneQuantity) {
        this.backGround1 = backGround;
        this.promotedEnemyPlaneQuantity = promotedEnemyPlaneQuantity;
        this.commonEnemyPlaneQuantity = commonEnemyPlaneQuantity;
    }

    public BackGround getBackGround1() {
        return backGround1;
    }

    public void setBackGround1(BackGround backGround1) {
        this.backGround1 = backGround1;
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
