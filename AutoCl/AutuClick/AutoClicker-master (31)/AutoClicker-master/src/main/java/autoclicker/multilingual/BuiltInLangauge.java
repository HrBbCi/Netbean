package autoclicker.multilingual;

import java.util.HashMap;
import java.util.Map;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public abstract class BuiltInLangauge implements ILangauge{

    public Map<String, String> map = new HashMap<>();

    @Override
    public String translate(String translationPath) {
        return map.getOrDefault(translationPath, translationPath);
    }

    public abstract void addItems(Map<String, String> map);

    public BuiltInLangauge(){
        addItems(map);
    }

}
