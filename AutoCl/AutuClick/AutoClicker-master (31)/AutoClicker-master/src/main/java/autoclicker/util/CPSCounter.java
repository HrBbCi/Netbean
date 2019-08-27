package autoclicker.util;

import java.util.ArrayList;
import java.util.List;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class CPSCounter {

    private List<Long> clicks = new ArrayList<>();

    public int getCPS(){
        clicks.removeIf(s -> s + 1000L < System.currentTimeMillis());
        return clicks.size();
    }

    public void click(){
        clicks.add(System.currentTimeMillis());
    }

}
