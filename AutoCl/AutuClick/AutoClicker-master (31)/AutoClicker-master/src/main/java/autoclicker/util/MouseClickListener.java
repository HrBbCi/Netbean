package autoclicker.util;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public abstract class MouseClickListener implements EventHandler<javafx.scene.input.MouseEvent> {


    @Override
    public void handle(MouseEvent event) {
        try {
            onMouseClicked(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void onMouseClicked(MouseEvent event) throws Exception;
}
