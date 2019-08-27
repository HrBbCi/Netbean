package autoclicker.settings;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class IntDeserializer implements IDeserializer {
    @Override
    public Object deserialize(String in) {
        return Integer.valueOf(in);
    }
}
