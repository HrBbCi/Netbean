package autoclicker.settings;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ObjectSerializer implements ISerializer {
    @Override
    public String serialize(Object in) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(in);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return DatatypeConverter.printHexBinary(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
