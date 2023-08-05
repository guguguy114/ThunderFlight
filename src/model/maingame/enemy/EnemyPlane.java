package model.maingame.enemy;

import control.GameConstStr;
import model.FlyingObject;

public abstract class EnemyPlane extends FlyingObject {
    public EnemyPlane() {
        objectName = GameConstStr.PLANE_NAME;
    }
}
