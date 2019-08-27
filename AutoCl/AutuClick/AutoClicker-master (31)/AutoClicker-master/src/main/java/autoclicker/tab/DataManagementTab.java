package autoclicker.tab;

import com.jfoenix.controls.JFXProgressBar;
import autoclicker.customcomponents.JFXProgressBarAnimation;
import autoclicker.diskmeasure.DiskMeasure;
import autoclicker.diskmeasure.DiskMeasureResult;
import autoclicker.diskmeasure.Measure;
import autoclicker.diskmeasure.MeasureResult;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class DataManagementTab implements Tab, Initializable{

    @FXML
    private JFXProgressBar systemProgress, settingsProgress, statisticProgress, langaugeProgress;
    @FXML
    private Label systemLbl, settingsLbl, statisticLbl, langaugeLbl, diskLbl;

    @Override
    public void retranslate() {

    }


    @Override
    public String getFile() {
        return "DataManagementTab.fxml";
    }

    @Override
    public String getTabName() {
        return ("autoclicker.tab.datamanagement");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MeasureResult result = Measure.measure();

        new JFXProgressBarAnimation(systemProgress, result.percentage(result.getSystemBytes()) / 100d);
        new JFXProgressBarAnimation(settingsProgress, result.percentage(result.getSettingsBytes()) / 100d);
        new JFXProgressBarAnimation(statisticProgress, result.percentage(result.getStatisticsBytes()) / 100d);
        new JFXProgressBarAnimation(langaugeProgress, result.percentage(result.getAssetsBytes()) / 100d);

        systemLbl.setText(result.getText(result.getSystemBytes()));
        settingsLbl.setText(result.getText(result.getSettingsBytes()));
        statisticLbl.setText(result.getText(result.getStatisticsBytes()));
        langaugeLbl.setText(result.getText(result.getAssetsBytes()));

        DiskMeasureResult diskResult = DiskMeasure.measure();

        diskLbl.setText(String.format("Free: %s (%s%%), Used: %s (%s%%)", diskResult.human(diskResult.getFree()), diskResult.getFreePercentage(), diskResult.human(diskResult.getUsed()), diskResult.getUsedPercentage()));


    }
}
