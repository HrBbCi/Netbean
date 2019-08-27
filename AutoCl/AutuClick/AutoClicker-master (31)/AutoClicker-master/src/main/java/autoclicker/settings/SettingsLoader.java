package autoclicker.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class SettingsLoader {

    public static void load() {

        if (!Settings.file.exists())
            try {
                Settings.file.createNewFile();
                SettingsSaver.save();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream(Settings.file), Charset.forName("UTF8")));

            for (Settings settings : Settings.values()) {
                if (settings.needSave())
                    settings.setValue(settings.getDeserializer().deserialize(properties.getProperty(settings.name())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

