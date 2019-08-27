package autoclicker.statistics;

import java.io.Serializable;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public interface Transformer<T> extends Serializable{
    String transform(T in);
    T untransform(String in);
}
