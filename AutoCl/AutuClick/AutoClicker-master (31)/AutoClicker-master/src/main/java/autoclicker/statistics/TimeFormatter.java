package autoclicker.statistics;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class TimeFormatter {

    public static String format(long in) {

        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        int days = 0;
        int years = 0;

        in *= 1000;

        while (in >= 1000) {
            seconds++;
            in -= 1000;
        }
        while (seconds >= 60) {
            minutes++;
            seconds -= 60;
        }
        while (minutes >= 60) {
            hours++;
            minutes -= 60;
        }
        while (hours >= 24) {
            days++;
            hours -= 24;
        }
        while (days >= 365) {
            years++;
            days -= 365;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (years != 0) {
            stringBuilder.append(String.format(translate(years == 1 ? "autoclicker.time.year" : "autoclicker.time.years"), years));
        }
        if (days != 0) {
            stringBuilder.append(String.format(translate(days == 1 ? "autoclicker.time.day" : "autoclicker.time.days"), days));
        }
        if (hours != 0) {
            stringBuilder.append(String.format(translate(hours == 1 ? "autoclicker.time.hour" : "autoclicker.time.hours"), hours));
        }
        if (minutes != 0) {
            stringBuilder.append(String.format(translate(minutes == 1 ? "autoclicker.time.minute" : "autoclicker.time.minutes"), minutes));
        }
        if (seconds != 0) {
            stringBuilder.append(String.format(translate(seconds == 1 ? "autoclicker.time.second" : "autoclicker.time.seconds"), seconds));
        }


        return stringBuilder.length() == 0 ? String.format(translate("autoclicker.time.seconds"), 0).substring(0, String.format(translate("autoclicker.time.seconds"), 0).length() - 2) : stringBuilder.toString().substring(0, stringBuilder.length() - 2);
    }

}
