package autoclicker.statistics;

import java.io.Serializable;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Statistic<T> implements Serializable{

    protected T value;
    protected Transformer<T> transformer;

    protected Statistic(T value, Transformer<T> transformer) {
        this.value = value;
        this.transformer = transformer;
    }

    public T getValue() {
        return value;
    }

    public Transformer<T> getTransformer() {
        return transformer;
    }

    protected void setValue(T value){
        this.value = value;
    }

}
