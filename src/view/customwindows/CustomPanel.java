package view.customwindows;

import control.GameConstStr;
import control.listener.ActionLis;
import control.listener.LevelComboboxLis;
import control.listener.RadioBtnLis;
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
    public JLabel speedLabel, levelChooseLabel, leveSelectedLabel, levelSelected, CQLabel, PQLabel, BLLabel;
    public JButton confirmBtn, cancelBtn;
    public JTextField commonQuantity, promoteQuantity, bossLife;
    public JRadioButton BGSelect1, BGSelect2, BGSelect3;
    public ButtonGroup buttonGroup;
    private boolean custom;
    private int CQ, PQ, BL;



    public String BG = "BG1";


    public CustomPanel(Game game) {
        CQ = 0;
        PQ = 0;
        BL = 100;

        setLayout(null);
        Font customFont = new Font("黑体", Font.BOLD, 15);
        ActionLis actionLis = new ActionLis(game);
        RadioBtnLis radioBtnLis = new RadioBtnLis(this);

        speedLabel = new JLabel("游戏速度：");
        speedLabel.setBounds(50,50,200,20);
        speedLabel.setFont(customFont);

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

        levelChooseLabel = new JLabel("选择关卡");
        levelChooseLabel.setBounds(50, 120, 100, 20);
        levelChooseLabel.setFont(customFont);

        String[] levels = new String[]{GameConstStr.LEVEL_ONE, GameConstStr.LEVEL_TWO, GameConstStr.LEVEL_THREE, GameConstStr.LEVEL_CUSTOM};
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

        BGSelect1 = new JRadioButton("BG1", false);
        BGSelect1.setBounds(50, 200, 80,20);
        BGSelect1.setFont(customFont);
        BGSelect1.setVisible(false);
        BGSelect1.setSelected(true);
        BGSelect1.addItemListener(radioBtnLis);

        BGSelect2 = new JRadioButton("BG2", false);
        BGSelect2.setBounds(150, 200, 80,20);
        BGSelect2.setFont(customFont);
        BGSelect2.setVisible(false);
        BGSelect2.addItemListener(radioBtnLis);

        BGSelect3 = new JRadioButton("BG3", false);
        BGSelect3.setBounds(250, 200, 80, 20);
        BGSelect3.setFont(customFont);
        BGSelect3.setVisible(false);
        BGSelect3.addItemListener(radioBtnLis);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(BGSelect1);
        buttonGroup.add(BGSelect2);
        buttonGroup.add(BGSelect3);

        cancelBtn = new JButton("取消");
        cancelBtn.setBounds(320, 300, 100, 40);
        cancelBtn.setFont(customFont);
        cancelBtn.setActionCommand(GameConstStr.CANCEL_CUSTOM);
        cancelBtn.addActionListener(actionLis);







        add(speedLabel);
        add(speedPutIn);
        add(levelChooseLabel);
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
        add(BGSelect1);
        add(BGSelect2);
        add(BGSelect3);
        add(cancelBtn);
    }

    public void custom(){
        CQLabel.setVisible(true);
        PQLabel.setVisible(true);
        BLLabel.setVisible(true);
        commonQuantity.setVisible(true);
        promoteQuantity.setVisible(true);
        bossLife.setVisible(true);
        BGSelect1.setVisible(true);
        BGSelect2.setVisible(true);
        BGSelect3.setVisible(true);
        custom = true;
    }

    public void noCustom(){
        CQLabel.setVisible(false);
        PQLabel.setVisible(false);
        BLLabel.setVisible(false);
        commonQuantity.setVisible(false);
        promoteQuantity.setVisible(false);
        bossLife.setVisible(false);
        BGSelect1.setVisible(false);
        BGSelect2.setVisible(false);
        BGSelect3.setVisible(false);
        custom = false;
    }

    public void setValue(){
        CQ = Integer.parseInt(commonQuantity.getText());
        PQ = Integer.parseInt(promoteQuantity.getText());
        BL = Integer.parseInt(bossLife.getText());
    }


















    public boolean isCustom() {
        return custom;
    }

    public int getCQ() {
        return CQ;
    }

    public int getPQ() {
        return PQ;
    }

    public int getBL() {
        return BL;
    }
}
