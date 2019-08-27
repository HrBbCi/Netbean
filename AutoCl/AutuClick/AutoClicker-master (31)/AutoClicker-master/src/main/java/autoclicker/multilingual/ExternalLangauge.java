package autoclicker.multilingual;


import javafx.scene.image.Image;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ExternalLangauge implements ILangauge {

    private final String langaugeCode;
    private final Properties properties;

    public ExternalLangauge(InputStream stream, String langaugeCode) {
        this.langaugeCode = langaugeCode;
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(stream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLangaugeCode() {
        return langaugeCode;
    }

    @Override
    public Image getLangaugeIcon() {
        return new Image(getClass().getResource("../../assets/lang/" + langaugeCode + ".png").toExternalForm());
    }

    @Override
    public String translate(String translationPath) {
        return properties.getProperty(translationPath, translationPath);
    }
}
