package autoclicker.util;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Maths {

    public static long calculateClickDelay(int cps) {
        return (long) ((1d / cps / 2d) * 1000L);
    }

    public static long calculateClickTime(int cps) {
        return (long) ((1d / cps / 2d - 0.0000001d) * 1000L);
    }

}
