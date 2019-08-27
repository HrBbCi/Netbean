package autoclicker.multilingual;

import javafx.scene.image.Image;

import java.util.Map;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class DefaultLangauge extends BuiltInLangauge{
    @Override
    public String getLangaugeCode() {
        return "en_US";
    }

    @Override
    public Image getLangaugeIcon() {
        return new Image("../../assets/lang/en_US.png");
    }

    @Override
    public void addItems(Map<String, String> map) {
        map.put("autoclicker.clickCounter.comboBox1.item4", "All Time");
        map.put("autoclicker.clickCounter.comboBox1.item3", "Clicks per Hour");
        map.put("autoclicker.clickCounter.comboBox1.item2", "Clicks per Minute");
        map.put("autoclicker.clickCounter.comboBox1.item1", "Clicks per Second");
        map.put("autoclicker.clickCounterDescription", "Click on the button and see your clicks!");
        map.put("autoclicker.time.minute", "%s minute, ");
        map.put("autoclicker.clicks", "Clicks");
        map.put("autoclicker.time.seconds", "%s seconds, ");
        map.put("autoclicker.time.years", "%s years, ");
        map.put("autoclicker.rmb", "Right Mouse Button");
        map.put("autoclicker.activation", "Activation");
        map.put("autoclicker.tab.generalSettings", "General Settings");
        map.put("autoclicker.tab.soon.message2", "Im Sorry, we're currently building this feature!");
        map.put("autoclicker.tab.soon.message1", "Under Construction!");
        map.put("systemIsHeadless", "Cannot create java.awt.Robot! Is system headless?");
        map.put("autoclicker.tab.clicks", "Clicks");
        map.put("autoclicker.time.second", "%s second, ");
        map.put("autoclicker.activate", "Enable");
        map.put("autoclicker.time.year", "%s year, ");
        map.put("autoclicker.time.days", "%s days, ");
        map.put("tooltip.bypassKeystrokesPlugins", "Bypasses some keystrokes plugins to detect keystrokes!<nl>If you want these plugins disable this option!<nl><nl>For Advanced Users:<nl>This enables the \"no click delay\" option and has no delay between press and release.");
        map.put("autoclicker.tab.wipestats", "Wipe Statistics");
        map.put("autoclicker.time.day", "%s day, ");
        map.put("autoclicker.time.hours", "%s hours, ");
        map.put("autoclicker.tab.datamanagement", "Data Management");
        map.put("systemIsWorking", "All systems working! ☺");
        map.put("autoclicker.tab.statistics", "Statistics");
        map.put("autoclicker.time.minutes", "%s minutes, ");
        map.put("hotkeysNotSupported", "Hotkeys (jnativehook) not supported!");
        map.put("autoclicker.tab.mode", "Mode");
        map.put("autoclicker.bypassKeystrokesPlugins", "Bypass KeyStrokes Plugins");
        map.put("tooltip.activation", "As soon as you press the specified key, the AutoClicker activates itself.<nl>If you do not like this key, just change it by clicking on \"You don't want this hotkey?\".");
        map.put("autoclicker.mmb", "Middle Mouse Button");
        map.put("autoclicker.directStopTechnology", "Use Direct Stop Technology");
        map.put("autoclicker.langaugeChange.text", "Langauge");
        map.put("autoclicker.tab.hotkeyselection", "Hotkey Selection");
        map.put("autoclicker.tab.clickCounter", "Click Counter");
        map.put("autoclicker.time.hour", "%s hour, ");
        map.put("autoclicker.activateordisable", "Enable/Disable");
        map.put("autoclicker.technologies", "Technologies");
        map.put("autoclicker.lmb", "Left Mouse Button");
        map.put("trayNotSupported", "Sorry, Tray is not supported on this system! Falling back to minimize...");
        map.put("tooltip.directStop", "If this setting is activated, the autoclicker stops immediately when you release the hotkey.");
        map.put("autoclicker.questionHotkey", "You don't want this hotkey?");
        map.put("errorTitle", "AutoClicker Boot Error - System Not Supported");
        map.put("tooltip.cps", "Here you can set the clicks per second.");

    }
}
