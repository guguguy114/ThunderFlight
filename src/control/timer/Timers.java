package control.timer;

import model.Game;

/**
 * 计时器总成
 */
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
