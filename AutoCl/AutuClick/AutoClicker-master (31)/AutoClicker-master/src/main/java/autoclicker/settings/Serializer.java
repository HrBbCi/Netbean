package autoclicker.settings;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Serializer implements ISerializer {
    @Override
    public String serialize(Object in) {
        return in.toString();
    }
}
