package model;

import control.timer.AnimationTimer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MiniMap extends FlyingObject{
    public MiniMap(Game game) {
        objX = 50;
        objY = 600;
        width = 200;
        height = 200;
        animationList = new ArrayList<>();
        animationTimer = new AnimationTimer(game);
        setAnimation();
    }

    @Override
    public void move(Game game) {

    }

    @Override
    public void attack(Game game) {

    }

    @Override
    public void dead(Game game) {

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
    public void hitDetect(Game game) {

    }

    @Override
    protected void setDeadImages() {

    }

    @Override
    protected void setAnimation() {
        for (int i = 1 ; i <= 30 ; i ++){
            Image image = new ImageIcon("img/radar/" + i + ".png").getImage();
            animationList.add(image);
        }
    }

    public void timerStart()
    {
        animationTimer.getTimer().start();
    }
}
