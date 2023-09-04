package control.listener;

import view.customwindows.CustomPanel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioBtnLis implements ItemListener {
    private final CustomPanel customPanel;
    public RadioBtnLis(CustomPanel customPanel) {
        this.customPanel = customPanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //System.out.println(((JRadioButton)e.getItem()).getText());
        customPanel.BG = ((JRadioButton)e.getItem()).getText();
    }
}
