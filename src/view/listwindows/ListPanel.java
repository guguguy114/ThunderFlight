package view.listwindows;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListPanel extends JPanel {

    JLabel titles;
    JLabel[] first, second, third;
    ArrayList<JLabel[]> players;
    String space;
    private ArrayList<Player> playerList;

    ListPanel() {
        setLayout(null);
        Font loginPageFont = new Font("黑体", Font.BOLD, 20);
        space = "      ";
        first = new JLabel[3];
        second = new JLabel[3];
        third = new JLabel[3];
        players = new ArrayList<>();
        players.add(first);
        players.add(second);
        players.add(third);
        int basicY = 150;
        int basicX = 100;


        titles = new JLabel("玩家名" + space + "排行榜" + space + "名次");
        titles.setBounds(100, 100, 500, 40);
        titles.setFont(loginPageFont);


        for (JLabel[] jLabels : players){
            for (int i = 0 ; i < jLabels.length ; i++) {
                jLabels[i] = new JLabel();
                jLabels[i] = new JLabel();
                jLabels[i].setBounds(basicX, basicY, 200, 40);
                basicX += 130;
                jLabels[i].setFont(loginPageFont);
                add(jLabels[i]);
            }
            basicX = 100;
            basicY += 50;
        }

        add(titles);
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void setList(){
        int key = 0;
        for (Player player : playerList){
            JLabel[] temp = players.get(key);
            temp[0].setText(player.getPlayerName());
            temp[1].setText(String.valueOf(player.getTotalScore()));
            temp[2].setText("第" + (key + 1) + "名");
            key++;
        }
    }

}
