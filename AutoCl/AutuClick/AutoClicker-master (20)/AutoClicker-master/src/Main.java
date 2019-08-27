import java.awt.event.InputEvent;
import java.lang.Thread;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initialize AC, Enter #Clicks:");

        int clicks = scanner.nextInt();

        System.out.print("Delay in seconds:");

        int delay = scanner.nextInt();

        System.out.println("AC start in 2 seconds");

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        AutoClicker clicker = new AutoClicker(300, 10);
        //setDelay in program
        clicker.setDelay(delay * 1000);

        for(int i =0; i< clicks; i++){
            clicker.clickMouse(InputEvent.BUTTON1_DOWN_MASK);
        }

        System.out.println("AC FIN");


    }

}
