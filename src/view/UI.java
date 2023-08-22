package view;

import model.Game;
import view.customwindows.CustomWin;
import view.gamewindows.GameWin;
import view.infowindows.InfoWin;
import view.listwindows.ListWin;
import view.loginwindows.LoginWin;

public class UI {
    private final CustomWin customWin;
    private final InfoWin infoWin;
    private final LoginWin loginWin;
    private final GameWin gameWin;
    private final ListWin listWin;

    public UI(Game game) {
        loginWin = new LoginWin(game);
        gameWin = new GameWin(game);
        infoWin = new InfoWin(game);
        customWin = new CustomWin(game);
        listWin = new ListWin(game);
    }

    public ListWin getListWin() {
        return listWin;
    }

    public GameWin getGameWin() {
        return gameWin;
    }

    public CustomWin getCustomWin() {
        return customWin;
    }

    public InfoWin getInfoWin() {
        return infoWin;
    }

    public LoginWin getLoginWin() {
        return loginWin;
    }
}
