package autoclicker.util;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Hotkey implements Serializable {

    public static final ArrayList<Integer> pressedKeys = new ArrayList<>();
    public static final int MOUSE4 = Integer.MIN_VALUE + 4, MOUSE5 = Integer.MIN_VALUE + 5;

    static {

        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);

            GlobalScreen.registerNativeHook();


            GlobalScreen.addNativeMouseListener(new NativeMouseListener() {
                @Override
                public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {

                }

                @Override
                public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
                    if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON4) {
                        pressedKeys.add(MOUSE4);
                    } else if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON5) {
                        pressedKeys.add(MOUSE5);
                    }
                }

                @Override
                public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
                    if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON4) {
                        pressedKeys.remove(((Object) MOUSE4));
                    } else if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON5) {
                        pressedKeys.remove(((Object) MOUSE5));
                    }
                }
            });

            GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
                @Override
                public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

                }

                @Override
                public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
                    synchronized (pressedKeys) {
                        if (!pressedKeys.contains(nativeKeyEvent.getKeyCode()))
                            pressedKeys.add(nativeKeyEvent.getKeyCode());
                    }
                }

                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
                    synchronized (pressedKeys) {
                        pressedKeys.remove(((Object) nativeKeyEvent.getKeyCode()));
                    }
                }
            });
        } catch (NativeHookException e) {
            e.printStackTrace();
        }


    }

    private final int keyCode;
    private final boolean shift;
    private final boolean control;
    private final boolean alt;

    public Hotkey(int keyCode, boolean shift, boolean control, boolean alt) {
        this.keyCode = keyCode;
        this.shift = shift;
        this.control = control;
        this.alt = alt;
    }

    public static Hotkey capture() {
        if (excludeExtraKeys().size() == 0)
            return null;
        if (excludeExtraKeys().size() > 1)
            return null;
        for (Integer integer : excludeExtraKeys()) {
            return new Hotkey(integer, isShiftPressed(), isControlPressed(), isAltPressed());
        }
        return null;
    }

    public static boolean isPressed(Hotkey hotkey) {
        for (Integer integer : excludeExtraKeys()) {
            if (hotkey.getKeyCode() == integer) {
                if (hotkey.isControl() && !isControlPressed()) // CTRL is pressed
                    continue;
                if (hotkey.isShift() && !isShiftPressed()) // SHIFT is pressed
                    continue;
                if (hotkey.isAlt() && !isAltPressed()) // ALT is pressed
                    continue;
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> excludeExtraKeys() {
        ArrayList<Integer> arr = new ArrayList<>();
        synchronized (pressedKeys) {
            for (Integer pressedKey : pressedKeys) {
                if (pressedKey == NativeKeyEvent.VC_CONTROL)
                    continue;
                if (pressedKey == NativeKeyEvent.VC_SHIFT)
                    continue;
                if (pressedKey == NativeKeyEvent.VC_ALT)
                    continue;
                arr.add(pressedKey);
            }
        }
        return arr;
    }

    public static String hotkeyToString(Hotkey hotkey) {
        String s = "";
        if (hotkey.isControl())
            s += "CTRL + ";
        if (hotkey.isShift())
            s += "SHIFT + ";
        if (hotkey.isAlt())
            s += "ALT + ";
        if (hotkey.getKeyCode() == MOUSE4) {
            s += "MOUSE 4";
            return s;
        }
        if (hotkey.getKeyCode() == MOUSE5) {
            s += "MOUSE 5";
            return s;
        }
        for (Field field : NativeKeyEvent.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.getType() != int.class)
                    continue;
                if (((Integer) field.get(null)) == hotkey.getKeyCode()) {
                    if (field.getName().startsWith("VC_") || field.getName().startsWith("VK_"))
                        s += field.getName().substring(3);
                    else
                        s += field.getName();
                    break;
                }
            } catch (Exception e) {

            }
        }
        return s;
    }

    private static boolean isShiftPressed() {
        return pressedKeys.contains(NativeKeyEvent.VC_SHIFT);
    }

    private static boolean isControlPressed() {
        return pressedKeys.contains(NativeKeyEvent.VC_CONTROL);
    }

    private static boolean isAltPressed() {
        return pressedKeys.contains(NativeKeyEvent.VC_ALT);
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isAlt() {
        return alt;
    }

    public boolean isControl() {
        return control;
    }

    public boolean isShift() {
        return shift;
    }

    @Override
    public String toString() {
        return String.format("Hotkey{keyCode: %s, control: %s, shift: %s, alt: %s}", keyCode, control, shift, alt);
    }

}
