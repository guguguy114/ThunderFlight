package model.maingame.enemy;

import control.GameConstStr;
import model.FlyingObject;
import model.Game;

import java.awt.*;

public abstract class EnemyPlane extends FlyingObject {


    public EnemyPlane(Image image, int x, int y, Game game) {
        objectName = GameConstStr.ENEMY_PLANE_NAME;
        objImg = image;
        objX = x;
        objY = y;
    }
}
