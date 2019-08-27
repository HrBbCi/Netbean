/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;


/**
 *
 * @author LENPOVO
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Logwriter lw1 = new Logwriter("thread", "test1.txt", 3000);
        Logwriter lw2 = new  Logwriter("thread2", "test1.txt", 4000);
        lw1.start();
        lw2.start();
    }
    
}
