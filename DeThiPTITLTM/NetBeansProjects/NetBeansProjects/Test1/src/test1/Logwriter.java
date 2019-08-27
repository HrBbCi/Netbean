/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Calendar;

/**
 *
 * @author LENPOVO
 */
public class Logwriter extends Thread{
    private  String filename;
    private long time;
    
    public Logwriter(String name, String filename, long time)
    {
        super(name);
        this.filename = filename;
        this.time = time;
    }
    
    public void run(){
    for(int i=0; i<10; i++){
            try{
            Writer  wr = new BufferedWriter(new FileWriter(filename,true));
            this.sleep(time);
                wr.append(getName() + "[" + Calendar.getInstance().getTime() + "]: Log-" + i + "\r\n");
            wr.close();

            }catch(Exception e){
    System.out.println(e.getStackTrace());
    }
    }
    }
}
