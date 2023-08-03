package model.maingame.hero;

import control.GameConstResourceUtil;
import model.FlyingObject;

public class HeroPlane extends FlyingObject {
    public boolean isUp, isDown, isLeft, isRight;
    public HeroPlane() {
        objImg = GameConstResourceUtil.HERO_DOWN;
    }

    @Override
    public void move() {
        if (isUp){
            objY -= 10;
        } else if (isDown) {
            objY += 10;
        } else if (isLeft) {
            objX -= 10;
        } else if (isRight) {
            objX += 10;
        }
    }

    public void stopHeroPlane(){
        isLeft = false;
        isRight = false;
        isUp = false;
        isDown = false;
    }
}
