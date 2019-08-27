package autoclicker; /**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */

import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.multilingual.Translator;
import autoclicker.plugins.PluginLoader;
import autoclicker.settings.AutoSaveThread;
import autoclicker.settings.Settings;
import autoclicker.settings.SettingsSaver;
import autoclicker.tab.GeneralSettingsTab;
import autoclicker.tab.TabLoader;
import autoclicker.util.ClickerThread;
import autoclicker.util.HotkeyChecker;
import autoclicker.util.SupportCheck;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AutoClickerGUI extends Application {

    public static Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {



        Runtime.getRuntime().addShutdownHook(new Thread(SettingsSaver::save));
        SupportCheck.checkSupport();
        AutoClickerGUI.stage = stage;
        Settings.load();
        new HotkeyChecker().start();
        new ClickerThread().start();
        new AutoSaveThread().start();
        AutoClickerGUIController.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/AutoClicker.fxml"));
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            if (event.getSceneY() > 40)
                return;
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();



        TabLoader.loadTab(scene, new GeneralSettingsTab());

        Translator.loadLangaugeInit();

        PluginLoader.loadPlugin(getClass().getProtectionDomain().getCodeSource().getLocation());

        PluginLoader.loadPlugins();



    }
}
