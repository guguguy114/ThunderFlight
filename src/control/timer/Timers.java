package control.timer;

import model.Game;

public class Timers {
    private final GlobalTimer globalTimer;
    private final AnimationTimer animationTimer;

    public Timers(Game game) {
        globalTimer = new GlobalTimer(game);
        animationTimer = new AnimationTimer(game);
    }

    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }

    public AnimationTimer getAnimationTimer() {
        return animationTimer;
    }
}
