import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClicker {

    private Robot robot;

    //delay between clicks in ms
    private int delay;
    //click count
    private int count;

    public AutoClicker(int delay, int count) {
        try{
            this.robot = new Robot();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //default delay
        this.delay = delay;
        this.count = count;
    }

    public int randomWithRange(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public void clickMouse(int button){
        // this method only press the button, does not release
        try {
            robot.mousePress(button);
            // adds static delay
            robot.delay(150);
            //release mousepress
            robot.mouseRelease(button);
            //robot.delay(delay);                    static delay
            robot.delay(randomWithRange(4,delay));  //random delay between clicks, starting from 5
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("AC start in 2 seconds");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0; i< this.count; i++){
            this.clickMouse(InputEvent.BUTTON1_DOWN_MASK);
        }

        System.out.println("AC FIN");

    }

    public void setDelay(int ms){
        this.delay = ms;
        //randomWithRange(5, ms);
    }
    public void setCount(int count) {
        this.count = count;
    }

}
