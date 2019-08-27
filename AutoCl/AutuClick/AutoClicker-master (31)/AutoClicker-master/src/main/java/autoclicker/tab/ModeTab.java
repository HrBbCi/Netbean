package autoclicker.tab;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ModeTab implements Initializable, Tab {



    @FXML
    private JFXCheckBox deactivatedButton;
    @FXML
    private JFXCheckBox fireButtonBtn;
    @FXML
    private JFXCheckBox switchFireButtonBtn;
    @FXML
    private JFXCheckBox holdToDisableBtn;
    @FXML
    private JFXCheckBox switchBtn;
    @FXML
    private JFXCheckBox holdBtn;

    @Override
    public boolean isCommingSoon() {
        return true;
    }

    @Override
    public void onPostLoad() {
    }

    private void turnOff(JFXCheckBox exclude) {
        for (JFXCheckBox mode : new JFXCheckBox[]{deactivatedButton, fireButtonBtn, switchFireButtonBtn, holdToDisableBtn, switchBtn, holdBtn}) {
            mode.setSelected(false);
        }
        exclude.setSelected(true);
    }

    @Override
    public void retranslate() {

    }

    @Override
    public String getFile() {
        return "ModeTab.fxml";
    }

    @Override
    public String getTabName() {
        return ("autoclicker.tab.mode");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
