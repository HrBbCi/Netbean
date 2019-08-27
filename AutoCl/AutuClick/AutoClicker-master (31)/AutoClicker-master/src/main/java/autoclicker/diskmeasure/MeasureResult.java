package autoclicker.diskmeasure;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class MeasureResult {

    protected long systemBytes, settingsBytes, statisticsBytes, assetsBytes;

    public long getSettingsBytes() {
        return settingsBytes;
    }

    public long getAssetsBytes() {
        return assetsBytes;
    }

    public long getStatisticsBytes() {
        return statisticsBytes;
    }

    public long getSystemBytes() {
        return systemBytes;
    }

    @Override
    public String toString() {
        return String.format("settings: %s (%s%%), system: %s (%s%%), statistics: %s (%s%%), assets: %s (%s%%)", settingsBytes, percentage(settingsBytes), systemBytes, percentage(systemBytes),  statisticsBytes, percentage(statisticsBytes), assetsBytes, percentage(assetsBytes));
    }

    public double percentage(long bytesCount) {
        double sum = getSettingsBytes() + getStatisticsBytes() + getSystemBytes() + getAssetsBytes();
        return Math.round(bytesCount / sum * 10000d) / 100d;
    }

    public String getText(long bytes){
        return percentage(bytes) + "% (" + human(bytes) + ")";
    }

    public static String human(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp-1) + "i";
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }

}
