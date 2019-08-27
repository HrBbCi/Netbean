package autoclicker.diskmeasure;

import autoclicker.settings.Settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class Measure {

    private static long folderSize(File directory, FilenameFilter filenameFilter) {
        long length = 0;
        for (File file : directory.listFiles(filenameFilter)) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file, filenameFilter);
        }
        return length;
    }

    private static long folderSize(File directory){
        return folderSize(directory, (dir, name) -> true);
    }

    public static MeasureResult measure(){
        return new MeasureResult(){
            {

                try {
                    File jar = new File(Measure.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

                    if (jar.isDirectory())
                        systemBytes = folderSize(jar);
                    else{
                        InputStream inputStream = new FileInputStream(jar);
                        systemBytes = inputStream.available();
                        inputStream.close();
                    }

                    settingsBytes = 0L;

                    for (Settings settings : Settings.values()) {

                        if (settings == Settings.STATS_SAVE)
                            continue;
                        try{
                            settingsBytes ++; // =
                            settingsBytes += settings.getSerializer().serialize(settings.getValue()).getBytes().length;
                            settingsBytes += settings.name().getBytes().length;
                        }catch (NullPointerException ex){
                        }
                    }
                    statisticsBytes = Settings.STATS_SAVE.getSerializer().serialize(Settings.STATS_SAVE.getValue()).getBytes().length;
                    assetsBytes = 0L;

                    File tar = new File(jar, "assets/");
                    if (tar.isDirectory()){
                        assetsBytes += folderSize(tar);
                    }

                    long guiBytes = folderSize(jar, (dir, name) -> name.endsWith(".fxml"));

                    assetsBytes += guiBytes;


                    systemBytes -= assetsBytes;



                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
    }

}
