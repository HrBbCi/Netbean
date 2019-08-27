package autoclicker.settings;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class BooleanDeserializer implements IDeserializer {
    @Override
    public Object deserialize(String in) {
        return Boolean.valueOf(in);
    }
}
