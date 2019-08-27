package autoclicker.settings;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ObjectDeserializer implements IDeserializer {
    @Override
    public Object deserialize(String in) {
        try {

            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(DatatypeConverter.parseHexBinary(in)));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
