package autoclicker.hotkeySelector;

import autoclicker.settings.Settings;
import autoclicker.util.Hotkey;
import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class HotkeySelectionGUIController implements Initializable {

    static Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Hotkey.capture() != null) {
                    Settings.HOTKEY.setValue(Hotkey.capture());
                    stop();
                    stage.hide();
                }
            }
        }.start();
    }
}
