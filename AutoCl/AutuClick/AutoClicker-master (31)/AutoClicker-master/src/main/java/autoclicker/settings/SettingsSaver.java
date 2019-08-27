package autoclicker.settings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class SettingsSaver {

    public static void save() {
        System.out.println("Saving settings...");
        Properties properties = new Properties();

        for (Settings setting : Settings.values()) {

            if (setting.needSave())
                properties.put(setting.name(), setting.getSerializer().serialize(setting.getValue()));

        }

        try {
            properties.save(new FileOutputStream(Settings.file), "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
