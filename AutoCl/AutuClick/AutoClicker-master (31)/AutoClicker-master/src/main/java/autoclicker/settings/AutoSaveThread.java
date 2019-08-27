package autoclicker.settings;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class AutoSaveThread extends Thread{

    @Override
    public void run() {
        setName("AutoSaveThread");
        while (true){
            // autosave every minute
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // save
            SettingsSaver.save();
        }
    }
}
