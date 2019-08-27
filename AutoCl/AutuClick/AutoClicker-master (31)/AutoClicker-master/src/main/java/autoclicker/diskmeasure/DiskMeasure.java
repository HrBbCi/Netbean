package autoclicker.diskmeasure;

import java.io.File;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class DiskMeasure {

    public static DiskMeasureResult measure(){

        return new DiskMeasureResult(){

            {

                free = 0L;
                used = 0L;

                File[] drives = File.listRoots();

                if (drives != null && drives.length > 0){

                    for (File drive : drives) {

                        free += drive.getFreeSpace();
                        used += drive.getTotalSpace() - drive.getFreeSpace();

                    }

                }

            }

        };
    }

}
