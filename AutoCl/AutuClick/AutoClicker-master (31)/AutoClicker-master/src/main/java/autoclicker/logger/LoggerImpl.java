package autoclicker.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class LoggerImpl<T> implements ILoggerImpl<T> {

    @Override
    public String buildMessage(T input, Level level, String source) {
        return String.format("[%s %s] %s: %s", new SimpleDateFormat("HH:mm:ss").format(new Date()), level.name(), source, input.toString());
    }

}
