package control.listener;

import view.customwindows.CustomPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LevelComboboxLis implements ItemListener {
    CustomPanel customPanelIn;
    public LevelComboboxLis(CustomPanel customPanelIn) {
        this.customPanelIn = customPanelIn;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            customPanelIn.levelSelected.setText((String) customPanelIn.levelChoosePutIn.getSelectedItem());
        }
    }
}
