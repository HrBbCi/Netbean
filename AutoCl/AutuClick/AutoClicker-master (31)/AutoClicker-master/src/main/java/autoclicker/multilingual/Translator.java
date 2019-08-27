package autoclicker.multilingual;

import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.settings.Settings;
import autoclicker.tab.TabLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Translator {

    private volatile static ILangauge langauge;

    static {
        loadLangaugeInit();
    }

    public static String translate(String path) {
        return langauge.translate(path).replace("<tab>", "\t").replace("<nl>", "\n");
    }


    public static void loadLangauge(String code, String name) {
        Settings.LANGAUGE.setValue(code);
        Settings.LANGAUGE_DEF.setValue(name);
        if (code.equalsIgnoreCase("en_US")) {
            langauge = new DefaultLangauge();
            if (AutoClickerGUIController.stage != null)
                AutoClickerGUIController.instance.retranslate();
            if (AutoClickerGUIController.stage != null) if (TabLoader.getCurrentTab() != null)
                TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), TabLoader.getCurrentTab(), true);
            return;
        }
        try {
            langauge = new ExternalLangauge(new FileInputStream(new File(Translator.class.getResource("/assets/lang/" + code + ".lang").getPath())), code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (AutoClickerGUIController.stage != null)
                AutoClickerGUIController.instance.retranslate();
            if (TabLoader.getCurrentTab() != null)
                TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), TabLoader.getCurrentTab(), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadLangaugeInit() {
        loadLangauge(((String) Settings.LANGAUGE.getValue()), ((String) Settings.LANGAUGE_DEF.getValue()));
    }

}
