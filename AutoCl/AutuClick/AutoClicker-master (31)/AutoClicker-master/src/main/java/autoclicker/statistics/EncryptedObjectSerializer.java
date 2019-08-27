package autoclicker.statistics;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import autoclicker.cryptography.DESEncryption;
import autoclicker.settings.ISerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class EncryptedObjectSerializer implements ISerializer {
    @Override
    public String serialize(Object in) {

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(0xFFCDF12);
            objectOutputStream.writeObject(in);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return HexBin.encode(DESEncryption.encrypt(byteArrayOutputStream.toByteArray(), Stats.getInstance().getSerial().getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
