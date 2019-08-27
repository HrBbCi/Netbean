package autoclicker.tab;

import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.statistics.Stats;
import autoclicker.statistics.TimeFormatter;
import autoclicker.util.ChangeDetector;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class StatisticsTab implements Tab, Initializable{

    @FXML
    private Label clicksLbl, hotkeyLbl, timeLbl;

    private ChangeDetector clicksChange = new ChangeDetector(), hotkeyChange = new ChangeDetector(), timeChange = new ChangeDetector();

    @Override
    public void retranslate() {

    }

    @Override
    public String getFile() {
        return "StatisticsTab.fxml";
    }

    @Override
    public String getTabName() {
        return ("autoclicker.tab.statistics");
    }

    @FXML
    private void wipeData(){
        TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), new WipeStatisticsSaveDialog());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retranslate();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    if (clicksChange.hasChanged(Stats.getInstance().getTotalClicks().getValue())){
                        clicksLbl.setText(String.valueOf(Stats.getInstance().getTotalClicks().getValue()));
                    }
                    if (hotkeyChange.hasChanged(Stats.getInstance().getHotkeyPresses().getValue())){
                        hotkeyLbl.setText(String.valueOf(Stats.getInstance().getHotkeyPresses().getValue()));
                    }
                    if (timeChange.hasChanged(Stats.getInstance().getTimeUsed().getValue())){
                        timeLbl.setText(TimeFormatter.format(Stats.getInstance().getTimeUsed().getValue()));
                    }
                });
                }
        }, 0, 200);
    }
}
