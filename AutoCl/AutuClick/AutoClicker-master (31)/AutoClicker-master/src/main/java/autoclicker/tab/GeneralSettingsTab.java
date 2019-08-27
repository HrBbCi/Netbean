package autoclicker.tab;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.customcomponents.BetterTooltip;
import autoclicker.customcomponents.CustomImageComboBoxCell;
import autoclicker.multilingual.Translator;
import autoclicker.settings.Settings;
import autoclicker.util.ChangeDetector;
import autoclicker.util.Hotkey;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class GeneralSettingsTab implements Initializable, Tab {
    @FXML
    private Label hotkeyLbl, enableDisableLabel, activationLabel, clicksLabel, technologiesLabel, langLbl;
    @FXML
    private JFXTextField cpsTf;
    @FXML
    private JFXComboBox<String> langComboBox;
    @FXML
    private JFXToggleButton enableCheckbox, directStopBtn, bypassBtn;
    @FXML
    private JFXButton questionHotkey;
    private ChangeDetector hotkeyChange = new ChangeDetector();
    private ChangeDetector enableCheckboxChange = new ChangeDetector();
    private ChangeDetector techBypassChange = new ChangeDetector();
    private ChangeDetector techDirectStopChange = new ChangeDetector();

    @Override
    public void retranslate() {
        langLbl.setText(translate("autoclicker.langaugeChange.text"));
        langComboBox.getItems().clear();
        langComboBox.setButtonCell(new CustomImageComboBoxCell());
        langComboBox.setCellFactory(c->new CustomImageComboBoxCell());
        langComboBox.getItems().addAll("English", "Deutsch");
        langComboBox.setOnAction(event -> {
            switch (langComboBox.getValue()){
                case "English":
                    Translator.loadLangauge("en_US", "English");
                    return;
                case "Deutsch":
                    Translator.loadLangauge("de_DE", "Deutsch");
                    return;
            }
        });
        langComboBox.getSelectionModel().select(String.valueOf(Settings.LANGAUGE_DEF.getValue()));
        enableCheckbox.setText(translate("autoclicker.activate"));
        enableDisableLabel.setText(translate("autoclicker.activateordisable"));
        activationLabel.setText(translate("autoclicker.activation"));
        clicksLabel.setText(translate("autoclicker.clicks"));
        technologiesLabel.setText(translate("autoclicker.technologies"));
        bypassBtn.setText(translate("autoclicker.bypassKeystrokesPlugins"));
        directStopBtn.setText(translate("autoclicker.directStopTechnology"));
        questionHotkey.setText(translate("autoclicker.questionHotkey"));

        bypassBtn.setTooltip(new BetterTooltip("bypassKeystrokesPlugins", bypassBtn));
        directStopBtn.setTooltip(new BetterTooltip("directStop", directStopBtn));
        cpsTf.setTooltip(new BetterTooltip("cps", cpsTf));
        hotkeyLbl.setTooltip(new BetterTooltip("activation", hotkeyLbl));
    }

    @Override
    public String getFile() {
        return "GeneralSettingsTab.fxml";
    }

    @Override
    public String getTabName() {
        return "autoclicker.tab.generalSettings";
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
retranslate();
        directStopBtn.setSelected((Boolean) Settings.TECH_DIRECT_STOP.getValue());
        bypassBtn.setSelected((Boolean) Settings.TECH_BYPASS.getValue());

        enableCheckbox.setSelected((Boolean) Settings.ENABLED.getValue());

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->update());
            }
        }, 5, 5);

        cpsTf.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case NUMPAD0:
                case NUMPAD1:
                case NUMPAD2:
                case NUMPAD3:
                case NUMPAD4:
                case NUMPAD5:
                case NUMPAD6:
                case NUMPAD7:
                case NUMPAD8:
                case NUMPAD9:
                case DIGIT0:
                case DIGIT1:
                case DIGIT2:
                case DIGIT3:
                case DIGIT4:
                case DIGIT5:
                case DIGIT6:
                case DIGIT7:
                case DIGIT8:
                case DIGIT9:
                    if (cpsTf.getText().length() > 8)
                        return;
                    Settings.CPS.setValue(Integer.valueOf(cpsTf.getText() + event.getCode().name().replace("NUMPAD", "").replace("DIGIT", "")));
                    break;
                default:
                    if (event.getCode() == KeyCode.BACK_SPACE) {
                        try {
                            Settings.CPS.setValue(Integer.valueOf(cpsTf.getText().substring(0, cpsTf.getText().length() - 1)));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            Settings.CPS.setValue(0);
                        }
                    }
            }


        });

    }


    private void update() {
        if (hotkeyChange.hasChanged(Settings.HOTKEY.getValue())) {
            hotkeyLbl.setText(Hotkey.hotkeyToString((Hotkey) Settings.HOTKEY.getValue()).toUpperCase());
        }
        if (enableCheckboxChange.hasChanged(enableCheckbox.isSelected())) {
            Settings.ENABLED.setValue(enableCheckbox.isSelected());
        }
        if (techBypassChange.hasChanged(bypassBtn.isSelected())){
            Settings.TECH_BYPASS.setValue(bypassBtn.isSelected());
        }
        if (techDirectStopChange.hasChanged(directStopBtn.isSelected())){
            Settings.TECH_DIRECT_STOP.setValue(directStopBtn.isSelected());
        }

        cpsTf.setText(String.valueOf(Settings.CPS.getValue()));


    }


    @FXML
    private void changeHotkey() {
        TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), new HotkeySelectionDialog());
    }

}
