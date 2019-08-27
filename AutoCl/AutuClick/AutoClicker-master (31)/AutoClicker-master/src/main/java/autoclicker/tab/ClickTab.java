package autoclicker.tab;

import com.jfoenix.controls.JFXCheckBox;
import autoclicker.settings.Settings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ClickTab implements Tab, Initializable {

    @FXML
    private JFXCheckBox lmb, mmb, rmb;
    @FXML
    private ImageView img;

    @FXML
    private void lmb() {
        if (lmb.isSelected()) {
            mmb.setSelected(false);
            rmb.setSelected(false);
            img.setImage(new Image(getClass().getResource("../../autoclicker/images/mouse/left.png").toExternalForm()));
            Settings.MOUSE_BUTTON.setValue(MouseEvent.BUTTON1);
        } else
            lmb.setSelected(true);
    }

    @FXML
    private void rmb() {
        if (rmb.isSelected()) {
            lmb.setSelected(false);
            mmb.setSelected(false);
            img.setImage(new Image(getClass().getResource("../../autoclicker/images/mouse/right.png").toExternalForm()));
            Settings.MOUSE_BUTTON.setValue(MouseEvent.BUTTON3);
        } else
            rmb.setSelected(true);
    }

    @FXML
    private void mmb() {
        if (mmb.isSelected()) {
            lmb.setSelected(false);
            rmb.setSelected(false);
            img.setImage(new Image(getClass().getResource("../../autoclicker/images/mouse/middle.png").toExternalForm()));
            Settings.MOUSE_BUTTON.setValue(MouseEvent.BUTTON2);
        } else
            mmb.setSelected(true);
    }

    @Override
    public void retranslate() {
        lmb.setText(translate("autoclicker.lmb"));
        mmb.setText(translate("autoclicker.mmb"));
        rmb.setText(translate("autoclicker.rmb"));
    }

    @Override
    public String getFile() {
        return "ClickTab.fxml";
    }

    @Override
    public String getTabName() {
        return "autoclicker.tab.clicks";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retranslate();
        switch (((int) Settings.MOUSE_BUTTON.getValue())) {

            case MouseEvent.BUTTON1:
                lmb();
                img.setImage(new Image(getClass().getResource("../../gui/images/mouse/left.png").toExternalForm()));
                break;
            case MouseEvent.BUTTON2:
                rmb();
                img.setImage(new Image(getClass().getResource("../../gui/images/mouse/right.png").toExternalForm()));
                break;
            case MouseEvent.BUTTON3:
                mmb();
                img.setImage(new Image(getClass().getResource("../../gui/images/mouse/middle.png").toExternalForm()));
                break;

        }
    }
}
