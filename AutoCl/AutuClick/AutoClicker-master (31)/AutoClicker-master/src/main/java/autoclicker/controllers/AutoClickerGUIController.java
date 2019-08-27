package autoclicker.controllers;

import autoclicker.Constants;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import autoclicker.customcomponents.TabEntry;
import autoclicker.tab.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class AutoClickerGUIController implements Initializable {

    @FXML
    private Pane stock;
    @FXML
    private Label mode, clicks, dataManagement, statistics, generalSettings, clickCounter;

    public static Stage stage;
    public static AutoClickerGUIController instance;
    @FXML
    private FontAwesomeIcon minimizeButton;

    @FXML
    private void modeView() {
        TabLoader.loadTab(stage.getScene(), new ModeTab());
    }

    @FXML
    private Label titleLbl;

    @FXML
    private void showStatistics(){TabLoader.loadTab(stage.getScene(), new StatisticsTab());}

    @FXML
    private void showDataManagement(){TabLoader.loadTab(stage.getScene(), new DataManagementTab());}

    public void retranslate(){
        titleLbl.setText(Constants.__APP_NAME__ + " " + Constants.__VERSION__);
        generalSettings.setText(translate("autoclicker.tab.generalSettings"));
        mode.setText(translate("autoclicker.tab.mode"));
        statistics.setText(translate("autoclicker.tab.statistics"));
        clicks.setText(translate("autoclicker.tab.clicks"));
        clickCounter.setText(translate("autoclicker.tab.clickCounter"));
        dataManagement.setText(translate("autoclicker.tab.datamanagement"));

        stock.getChildren().removeAll(
                stock.getChildren().stream().filter(s-> s.getClass().getName().equalsIgnoreCase(TabEntry.class.getName())).toArray(Node[]::new)
        );
        stock.getChildren().removeAll(
                stock.getChildren().stream().filter(s->s.getId() != null).filter(s-> !s.getId().toLowerCase().contains("wrench")).filter(s-> s.getClass().getName().equalsIgnoreCase(FontAwesomeIcon.class.getName())).toArray(Node[]::new)
        );

        TabLoader.getTabs().forEach((s)->s.show(stock));

    }


    @FXML
    private void closeProgram() {
        stage.hide();
        System.exit(999);
    }


    @FXML
    private void minimizeProgram() {
        stage.setIconified(!stage.isIconified());
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;

        retranslate();



    }

    @FXML
    private void generalSettings() {
        TabLoader.loadTab(stage.getScene(), new GeneralSettingsTab());
    }

    @FXML
    private void clickCounter() {
        TabLoader.loadTab(stage.getScene(), new ClickCounterTab());
    }

    @FXML
    private void clickTab(){TabLoader.loadTab(stage.getScene(), new ClickTab());}
}
