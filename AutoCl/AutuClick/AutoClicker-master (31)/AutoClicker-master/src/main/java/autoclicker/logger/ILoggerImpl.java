package autoclicker.logger;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public interface ILoggerImpl<T> {

    String buildMessage(T input, Level level, String source);

}
