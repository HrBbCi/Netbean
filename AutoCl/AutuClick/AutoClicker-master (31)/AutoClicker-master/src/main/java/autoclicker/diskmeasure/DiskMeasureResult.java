package autoclicker.diskmeasure;

import java.text.DecimalFormat;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class DiskMeasureResult {

    protected long free, used;

    public long getFree() {
        return free;
    }

    public long getUsed() {
        return used;
    }

    public String getFreePercentage() {
        return new DecimalFormat("0.00").format(((double) getFree()) / (((double) getFree()) + ((double) getUsed())) * 100.);
    }

    public String getUsedPercentage() {
        return new DecimalFormat("0.00").format(((double) getUsed()) / (((double) getFree()) + ((double) getUsed())) * 100.);
    }

    public String human(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "i";
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}
