package autoclicker.plugins;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public interface IPlugin {

    default void onLoad() {
    }

    default void onEnable() {
    }

    default void onDisable() {
    }

    String getName();
}
