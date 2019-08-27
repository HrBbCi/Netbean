package autoclicker.util;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ChangeDetector {

    private int hash = -1;

    public boolean hasChanged(Object value) {
        if (value == null) {
            return false;
        }
        if (hash == -1) {
            hash = value.hashCode();
            return true;
        }

        if (hash != value.hashCode()) {
            hash = value.hashCode();
            return true;
        }
        return false;

    }

}
