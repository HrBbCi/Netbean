package autoclicker.logger;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public enum Level {

    ALWAYS(-999999999),
    FATAL_ERROR(100),
    ERROR(200),
    WARNING(500),
    INFO(800),
    DEBUG(1000);

    private int lvl;

    Level(int lvl){
        this.lvl = lvl;
    }

    public int getLevel() {
        return lvl;
    }
}
