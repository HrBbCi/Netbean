package autoclicker.statistics;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class IntTransformer implements Transformer<Integer>{
    @Override
    public String transform(Integer in) {
        return String.valueOf(in);
    }

    @Override
    public Integer untransform(String in) {
        return Integer.valueOf(in);
    }
}
