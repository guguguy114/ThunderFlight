package view.customwindows;

import control.listener.LevelComboboxLis;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * 自定义界面
 */
public class CustomPanel extends JPanel {// todo ： 有滑块，关卡选项，皮肤选择

    public JSlider speedPutIn;
    public JComboBox<String> levelChoosePutIn;
    public JLabel speed, levelChoose, leveSelectedLabel, levelSelected;

    public CustomPanel(Game game) {
        setLayout(null);
        Font customFont = new Font("黑体", Font.BOLD, 15);

        speed = new JLabel("游戏速度：");
        speed.setBounds(50,50,200,20);
        speed.setFont(customFont);

        speedPutIn = new JSlider(0,3);
        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("随机速度"));
        labelTable.put(1, new JLabel("1"));
        labelTable.put(2, new JLabel("2"));
        labelTable.put(3, new JLabel("3"));
        speedPutIn.setMajorTickSpacing(1);
        speedPutIn.setSnapToTicks(true);
        speedPutIn.setPaintLabels(true);
        speedPutIn.setPaintTicks(true);
        speedPutIn.setLabelTable(labelTable);
        speedPutIn.setBounds(130,50,400,50);
        speedPutIn.setFont(customFont);

        levelChoose = new JLabel("选择关卡");
        levelChoose.setBounds(50, 120, 100, 20);
        levelChoose.setFont(customFont);

        String[] levels = new String[]{"第一关", "第二关", "第三关", "自定义"};
        levelChoosePutIn = new JComboBox<>(levels);
        levelChoosePutIn.setMaximumRowCount(5);
        levelChoosePutIn.setBounds(130, 120, 100, 20);
        levelChoosePutIn.setFont(customFont);
        levelChoosePutIn.addItemListener(new LevelComboboxLis(this));

        leveSelectedLabel = new JLabel("你选择了 ");
        leveSelectedLabel.setBounds(250, 120, 100 ,20);
        leveSelectedLabel.setFont(customFont);

        levelSelected = new JLabel((String) levelChoosePutIn.getSelectedItem());
        levelSelected.setBounds(350,120,100,20);
        levelSelected.setFont(customFont);

        add(speed);
        add(speedPutIn);
        add(levelChoose);
        add(levelChoosePutIn);
        add(leveSelectedLabel);
        add(levelSelected);
    }
}
