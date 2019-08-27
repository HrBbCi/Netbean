package autoclicker.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
@Retention(RetentionPolicy.SOURCE)
public @interface OldFeature {

    String removedSince() default "<non version given>";

}
