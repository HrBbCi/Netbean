package autoclicker.customcomponents;

import autoclicker.multilingual.Translator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.lang.reflect.Field;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class BetterTooltip extends Tooltip{

    public BetterTooltip(String translationPath, Node parent) {
        super(Translator.translate("tooltip."+translationPath));
        try{
            Field b = Tooltip.class.getDeclaredField("BEHAVIOR");
            b.setAccessible(true);
            Object obj = b.get(this);
            Field t = obj.getClass().getDeclaredField("activationTimer");
            t.setAccessible(true);
            Timeline timeline = (Timeline) t.get(obj);
            timeline.getKeyFrames().clear();
            timeline.getKeyFrames().add(new KeyFrame(new Duration(250)));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        parent.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            setX(event.getScreenX());
            setY(event.getScreenY());
        });

    }





}
