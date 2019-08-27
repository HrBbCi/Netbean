package autoclicker.logger;

import java.util.HashMap;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Logger {

    private static HashMap<String, LoggerInstance> loggers = new HashMap<>();
    private static final String GLOBAL_LOGGER = "GlobalLogger";

    public static LoggerInstance<Object> getGlobalLogger(){
        return getLogger(GLOBAL_LOGGER);
    }

    public static <T> LoggerInstance<T> createLogger(String name, Class<T> clazz){
        loggers.remove(name);
        return loggers.put(name, new LoggerInstance<T>(name, new LoggerImpl<>()));
    }

    public static <T> LoggerInstance<T> getLogger(String name){
        return loggers.getOrDefault(name, createLogger(name, Object.class));
    }

    public static <T> void log(String loggerName, T message, Level level){
        if (!loggers.containsKey(loggerName))
            createLogger(loggerName, message.getClass());
        getLogger(loggerName).log(message, level);
    }

    public static <T> void log(String loggerName, T message){
        log(loggerName, message, Level.INFO);
    }

    public static <T> void log(T message){
        log(GLOBAL_LOGGER, message);
    }

    public static <T> void log(String message, Level level){
        log(GLOBAL_LOGGER, message, level);
    }

}
