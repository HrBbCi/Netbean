package autoclicker.statistics;

import autoclicker.settings.Settings;

import java.io.Serializable;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Stats implements Serializable{

    private static final long serialVersionUID = 8747787487484787847L;

    public final Statistic<Integer> TOTAL_CLICKS = new Statistic<>(0, new IntTransformer());
    public final Statistic<Integer> TIME_USED = new Statistic<>(0, new IntTransformer());
    public final Statistic<Integer> HOTKEY_PRESSES = new Statistic<>(0, new IntTransformer());
    public final Statistic<String> SERIAL = new Statistic<>("no serial", new StringTransformer());

    protected Statistic<String> getSerial() {
        return SERIAL;
    }

    public Statistic<Integer> getHotkeyPresses() {
        return HOTKEY_PRESSES;
    }

    public Statistic<Integer> getTimeUsed() {
        return TIME_USED;
    }

    public Statistic<Integer> getTotalClicks() {
        return TOTAL_CLICKS;
    }



    public static Stats getInstance() {
        return (Stats) Settings.STATS_SAVE.getValue();
    }
}
