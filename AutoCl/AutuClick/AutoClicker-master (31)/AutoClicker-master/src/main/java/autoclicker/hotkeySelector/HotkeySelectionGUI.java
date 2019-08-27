package autoclicker.hotkeySelector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class HotkeySelectionGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../HotkeySelection.fxml"));
        Scene scene = new Scene(root);
        HotkeySelectionGUIController.stage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.centerOnScreen();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.showAndWait();

    }

}
