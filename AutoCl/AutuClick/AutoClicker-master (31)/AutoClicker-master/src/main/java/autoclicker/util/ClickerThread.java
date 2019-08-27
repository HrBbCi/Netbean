package autoclicker.util;

import autoclicker.settings.Settings;
import autoclicker.statistics.StatisticsAccessor;
import autoclicker.statistics.Stats;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ClickerThread extends Thread {

    private static Robot r;

    static {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        setName("ClickerThread");
        while (true) {
            while (((Boolean) Settings.ENABLED.getValue())) {
                while (((Boolean) Settings.RUNNING.getValue())) {
                    try {

                        doSecond();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doSecond() throws InterruptedException {

        int cps = (Integer) Settings.CPS.getValue();
        int mouseval = InputEvent.getMaskForButton((Integer) Settings.MOUSE_BUTTON.getValue());



        for (int i = 0; i < cps; i++) {

            if (!((Boolean) Settings.TECH_DIRECT_STOP.getValue())){
                if (!((Boolean) Settings.TECH_BYPASS.getValue())){
                    Thread.sleep(Maths.calculateClickDelay(cps));
                    r.mousePress(mouseval);
                    Thread.sleep(Maths.calculateClickTime(cps));
                    r.mouseRelease(mouseval);
                }else{
                    r.mousePress(mouseval);
                    r.mouseRelease(mouseval);
                    Thread.sleep(Maths.calculateClickDelay(cps));
                    Thread.sleep(Maths.calculateClickTime(cps));
                }
            }else{
                if (!((Boolean) Settings.RUNNING.getValue()))
                    return;
                if (!((Boolean) Settings.TECH_BYPASS.getValue())){
                    Thread.sleep(Maths.calculateClickDelay(cps));
                    r.mousePress(mouseval);
                    Thread.sleep(Maths.calculateClickTime(cps));
                    r.mouseRelease(mouseval);
                }else{
                    r.mousePress(mouseval);
                    r.mouseRelease(mouseval);
                    Thread.sleep(Maths.calculateClickDelay(cps));
                    Thread.sleep(Maths.calculateClickTime(cps));
                }
            }


        }
        StatisticsAccessor.access(Stats.getInstance().getTimeUsed(), Stats.getInstance().getTimeUsed().getValue() + 1);
        StatisticsAccessor.access(Stats.getInstance().getTotalClicks(), Stats.getInstance().getTotalClicks().getValue() + cps);
    }
}
