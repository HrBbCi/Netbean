package autoclicker.statistics;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class StringTransformer implements Transformer<String>{
    @Override
    public String transform(String in) {
        return in;
    }

    @Override
    public String untransform(String in) {
        return in;
    }
}
