package autoclicker.logger;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class LoggerInstance<T> {

    private String source;
    private LoggerImpl<T> logger;

    public LoggerInstance(String source, LoggerImpl<T> logger) {
        this.source = source;
        this.logger = logger;
    }

    public void log(T message, Level level){
        System.err.println(logger.buildMessage(message, level, source));
    }

    public void log(T message){
        log(message, Level.INFO);
    }

}
