package autoclicker.plugins;

import java.lang.annotation.*;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PluginClass {
    long SERIAL();
}
