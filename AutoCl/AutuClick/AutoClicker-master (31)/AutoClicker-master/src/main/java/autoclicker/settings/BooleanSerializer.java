package autoclicker.settings;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class BooleanSerializer implements ISerializer {
    @Override
    public String serialize(Object in) {
        return String.valueOf(in);
    }
}
