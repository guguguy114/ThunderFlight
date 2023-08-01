package model;

import control.timer.GlobalTimer;
import view.UI;

public class Game {
    private Player player;
    private UI ui;
    private GameLevel gameLevel;
    private int gameMode;
    private GlobalTimer globalTimer;

    public Game() {
        ui = new UI(this);
    }
}
