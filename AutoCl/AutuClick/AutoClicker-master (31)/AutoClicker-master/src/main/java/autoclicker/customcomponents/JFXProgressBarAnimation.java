package autoclicker.customcomponents;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class JFXProgressBarAnimation extends Transition {

    private final JFXProgressBar node;
    private final double value;

    public JFXProgressBarAnimation(JFXProgressBar node, double value) {
        this.node = node;
        this.value = value;
        setInterpolator(Interpolator.EASE_BOTH);
        setCycleDuration(Duration.seconds(2));
        play();
    }

    @Override
    protected void interpolate(double frac) {

        if (frac > value)
            return;
        node.setProgress(frac);


    }
}
