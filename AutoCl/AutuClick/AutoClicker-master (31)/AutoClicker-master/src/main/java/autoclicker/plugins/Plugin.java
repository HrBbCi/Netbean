package autoclicker.plugins;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Plugin implements IPlugin {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
