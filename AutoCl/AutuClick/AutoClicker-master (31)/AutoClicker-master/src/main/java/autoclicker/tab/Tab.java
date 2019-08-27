package autoclicker.tab;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public interface Tab {

    void retranslate();

    String getFile();

    default boolean isCommingSoon(){
        return false;
    }


    default Pane load() {
        try {
            return FXMLLoader.load(getClass().getResource("/" + getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String getTabName();

    default String getName(){
        return translate(getTabName());
    }

    default void onPostLoad() {
    }

}
