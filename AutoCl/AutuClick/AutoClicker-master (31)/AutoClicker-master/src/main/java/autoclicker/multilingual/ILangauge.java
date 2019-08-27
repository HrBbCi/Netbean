package autoclicker.multilingual;


import javafx.scene.image.Image;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public interface ILangauge {

    String getLangaugeCode();
    Image getLangaugeIcon();

    String translate(String translationPath);

}
