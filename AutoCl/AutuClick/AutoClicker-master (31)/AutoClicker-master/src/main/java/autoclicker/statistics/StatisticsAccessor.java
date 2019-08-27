package autoclicker.statistics;

import autoclicker.util.ClickerThread;
import autoclicker.util.HotkeyChecker;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class StatisticsAccessor {

    protected static final Class[] accessors = new Class[]{ClickerThread.class, HotkeyChecker.class};
    protected static final String INFO1 = "Everything you do is self-deception.";
    protected static final String INFO2 = "Everything you do is self-deception.";
    protected static final String INFO3 = "Everything you do is self-deception.";

    public static <T> void access(Statistic<T> statistic, T value) {
        try {
            throw new Exception();
        } catch (Exception ex) {

            for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                for (Class accessor : accessors) {
                    if (stackTraceElement.getClassName().equals(accessor.getName())) {
                        statistic.setValue(value);
                        return;
                    }
                }
            }

        }


        throw new IllegalAccessError("Class tried to access protected statistic");

    }

}
