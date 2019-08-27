package autoclicker.util;

import autoclicker.settings.Settings;
import autoclicker.statistics.StatisticsAccessor;
import autoclicker.statistics.Stats;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class HotkeyChecker extends Thread {

    private ChangeDetector changeDetector = new ChangeDetector();

    @Override
    public void run() {
        setName("HotkeyChecker-Thread");
        while (true){
            boolean val = Hotkey.isPressed(((Hotkey) Settings.HOTKEY.getValue()));
            if (changeDetector.hasChanged(val)){
                Settings.RUNNING.setValue(val);
                if (val){
                    StatisticsAccessor.access(Stats.getInstance().getHotkeyPresses(), Stats.getInstance().getHotkeyPresses().getValue() + 1);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
