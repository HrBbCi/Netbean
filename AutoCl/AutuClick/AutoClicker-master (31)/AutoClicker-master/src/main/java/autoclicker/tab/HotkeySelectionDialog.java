package autoclicker.tab;

import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.settings.Settings;
import autoclicker.util.Hotkey;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class HotkeySelectionDialog implements Tab, Initializable{

    @FXML
    private AnchorPane dialog;

    @FXML
    private void abort(){
        new Transition() {
            {
                setCycleDuration(Duration.seconds(0.5));
                setInterpolator(Interpolator.EASE_BOTH);
            }
            @Override
            protected void interpolate(double frac) {
                dialog.setEffect(new GaussianBlur(5d-Math.round(frac * 5d)));
                if (frac == 1){
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), new GeneralSettingsTab());
                        }
                    }, 20);
                }
            }
        }.play();
    }

    @Override
    public void retranslate() {

    }

    @Override
    public String getFile() {
        return "HotkeySelection.fxml";
    }

    @Override
    public String getTabName() {
        return ("autoclicker.tab.hotkeyselection");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dialog.getChildren().add(new GeneralSettingsTab().load());
        dialog.setDisable(true);
        new Transition() {
            {
                setInterpolator(Interpolator.EASE_BOTH);
                setCycleDuration(Duration.seconds(0.5));
            }
            @Override
            protected void interpolate(double frac) {
                dialog.setEffect(new GaussianBlur(Math.round(frac * 5d)));
            }
        }.play();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Hotkey.capture() != null) {
                    Settings.HOTKEY.setValue(Hotkey.capture());
                    abort();
                    stop();
                }
            }
        }.start();
    }
}
