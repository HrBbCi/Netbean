package autoclicker.customcomponents;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class CustomImageComboBoxCell extends ListCell<String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        if (item != null) {
            String langName;
            switch (item) {
                case "Deutsch":
                    langName = "de_DE";
                    break;
                case "English":
                    langName = "en_US";
                    break;
                default:
                    return;
            }
            setText("  "+item);
            ImageView imageView = new ImageView(new Image(getClass().getResource("/assets/lang/" + langName + ".png").toExternalForm()));
            imageView.setFitWidth(32 / 4 * 3);
            imageView.setFitHeight(24 / 4 * 3);
            setGraphic(imageView);
        }
    }
}
