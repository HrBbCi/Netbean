package autoclicker.util;

import autoclicker.logger.Level;
import autoclicker.logger.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class SupportCheck {

    public static void checkSupport() {

        if (!SystemTray.isSupported()) {
            Logger.log(translate("trayNotSupported"), Level.WARNING);
        }

        try {
            java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(java.util.logging.Level.OFF);
            GlobalScreen.registerNativeHook();
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            showError(translate("hotkeysNotSupported"));
            System.exit(0);
        }

        try {
            new Robot();
        } catch (AWTException e) {
            showError(translate("systemIsHeadless"));
        }

        Logger.log(translate("systemIsWorking"));

    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, translate("errorTitle"), JOptionPane.ERROR_MESSAGE);
    }

}
