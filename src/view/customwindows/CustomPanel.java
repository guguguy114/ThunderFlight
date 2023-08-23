package view.customwindows;

import control.GameConstStr;
import control.listener.ActionLis;
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
    public JLabel speed, levelChoose, leveSelectedLabel, levelSelected, CQLabel, PQLabel, BLLabel;
    public JButton confirmBtn;
    public JTextField commonQuantity, promoteQuantity, bossLife;
    private boolean custom;
    private int CQ, PQ, BL;


    public CustomPanel(Game game) {
        CQ = 0;
        PQ = 0;
        BL = 100;

        setLayout(null);
        Font customFont = new Font("黑体", Font.BOLD, 15);
        ActionLis actionLis = new ActionLis(game);

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

        confirmBtn = new JButton("确定");
        confirmBtn.setBounds(460, 300, 100, 40);
        confirmBtn.setActionCommand(GameConstStr.LEVEL_CONFIRM);
        confirmBtn.setFont(customFont);
        confirmBtn.addActionListener(actionLis);

        CQLabel = new JLabel("普通敌机数量：");
        CQLabel.setBounds(50, 150, 120 ,40);
        CQLabel.setFont(customFont);
        CQLabel.setVisible(false);

        PQLabel = new JLabel("精英敌机数量：");
        PQLabel.setBounds(225, 150, 120, 40);
        PQLabel.setFont(customFont);
        PQLabel.setVisible(false);

        BLLabel = new JLabel("BOSS生命值：");
        BLLabel.setBounds(400, 150, 120, 40);
        BLLabel.setFont(customFont);
        BLLabel.setVisible(false);

        commonQuantity = new JTextField();
        commonQuantity.setText(String.valueOf(CQ));
        commonQuantity.setBounds(165, 160, 50 ,20);
        commonQuantity.setFont(customFont);
        commonQuantity.setVisible(false);

        promoteQuantity = new JTextField();
        promoteQuantity.setText(String.valueOf(PQ));
        promoteQuantity.setBounds(340, 160, 50 ,20);
        promoteQuantity.setFont(customFont);
        promoteQuantity.setVisible(false);

        bossLife = new JTextField();
        bossLife.setText(String.valueOf(BL));
        bossLife.setBounds(500, 160, 50 ,20);
        bossLife.setFont(customFont);
        bossLife.setVisible(false);

        add(speed);
        add(speedPutIn);
        add(levelChoose);
        add(levelChoosePutIn);
        add(leveSelectedLabel);
        add(levelSelected);
        add(confirmBtn);
        add(CQLabel);
        add(PQLabel);
        add(BLLabel);
        add(commonQuantity);
        add(promoteQuantity);
        add(bossLife);
    }

    public void custom(){
        CQLabel.setVisible(true);
        PQLabel.setVisible(true);
        BLLabel.setVisible(true);
        commonQuantity.setVisible(true);
        promoteQuantity.setVisible(true);
        bossLife.setVisible(true);
        custom = true;
    }

    public void noCustom(){
        CQLabel.setVisible(false);
        PQLabel.setVisible(false);
        BLLabel.setVisible(false);
        commonQuantity.setVisible(false);
        promoteQuantity.setVisible(false);
        bossLife.setVisible(false);
        custom = false;
    }


















    public boolean isCustom() {
        return custom;
    }
}
