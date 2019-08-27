package autoclicker.settings;

import autoclicker.logger.Level;
import autoclicker.logger.Logger;
import autoclicker.statistics.EncryptedObjectDeserializer;
import autoclicker.statistics.EncryptedObjectSerializer;
import autoclicker.statistics.Stats;
import autoclicker.util.Hotkey;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.io.File;
import java.util.HashMap;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public enum Settings {

    HOTKEY(new Hotkey(NativeKeyEvent.VC_P, true, false, false), new ObjectDeserializer(), new ObjectSerializer()),
    TOTAL_CLICKS(0, new IntDeserializer(), new IntSerializer()),
    ENABLED(true, new BooleanDeserializer(), new BooleanSerializer()),
    RUNNING(false),
    CPS(1, new IntDeserializer(), new IntSerializer()),
    MOUSE_BUTTON(1, new IntDeserializer(), new IntSerializer()),
    TECH_BYPASS(true, new BooleanDeserializer(), new BooleanSerializer()),
    TECH_DIRECT_STOP(true, new BooleanDeserializer(), new BooleanSerializer()),
    LANGAUGE("en_US", new Deserializer(), new Serializer()),
    LANGAUGE_DEF("English", new Deserializer(), new Serializer()),
    STATS_SAVE(new Stats(), new EncryptedObjectDeserializer(), new EncryptedObjectSerializer()) // encrypted object

    ;

    public void wipe(){
        setValue(value);
        SettingsSaver.save();
        SettingsLoader.load();
    }


    public static final File file = new File("settings.properties");
    protected final HashMap<String, Object> overrideValues = new HashMap<>();
    private final Object value;
    private final IDeserializer deserializer;
    private final ISerializer serializer;
    private final boolean save;

    Settings(final Object value) {
        this.value = value;
        this.deserializer = null;
        this.serializer = null;
        this.save = false;
    }

    Settings(final Object value, final IDeserializer deserializer, final ISerializer serializer) {
        this.value = value;
        this.deserializer = deserializer;
        this.serializer = serializer;
        this.save = true;
    }


    public static void load() {
        SettingsLoader.load();
    }

    public boolean needSave() {
        return save;
    }

    public IDeserializer getDeserializer() {
        return deserializer;
    }

    public ISerializer getSerializer() {
        return serializer;
    }

    public Object getValue() {
        return overrideValues.getOrDefault(name(), value);
    }

    public void setValue(Object value) {
        overrideValues.remove(this.name());
        overrideValues.put(name(), value);
        Logger.getLogger("Settings").log(String.format("%s was set to %s", name(), value), Level.DEBUG);
    }

}
