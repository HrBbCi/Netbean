package autoclicker.statistics;

import autoclicker.cryptography.DESEncryption;
import autoclicker.settings.IDeserializer;
import autoclicker.settings.Settings;
import autoclicker.settings.SettingsLoader;
import autoclicker.settings.SettingsSaver;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class EncryptedObjectDeserializer implements IDeserializer {
    @Override
    public Object deserialize(String in) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(DESEncryption.decrypt(HexBin.decode(in), Stats.getInstance().getSerial().getValue()));
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            int magicHeader = (int) objectInputStream.readObject();
            if (magicHeader != 0xFFCDF12){
                System.out.println("MAGIC HEADER DOESN'T THE SAME FILE READ ERROR! TRY TO DELETE CONFIGURATION FILE!");
                System.out.println("MAGIC HEADER = "+magicHeader);
                System.out.println("NORMAL MAGIC HEADER = "+0xFFCDF12 + " (Hex: 0xFFCDF12)");
                System.exit(0);
            }

            try{
                return objectInputStream.readObject();
            }catch (Exception ex){

                System.out.println("INVALID SERIAL VERSION YOU'RE USING OLD CONFIG!");
                System.out.println("UPDATING CONFIG!");

                Settings.STATS_SAVE.setValue(new Stats());

                System.out.println("SAVING UPDATED CONFIG...");

                SettingsSaver.save();

                System.out.println("RELOADING NEW CONFIG...");

                SettingsLoader.load();

                System.out.println("CONFIG RELOADED!");

                return null;

            }



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
