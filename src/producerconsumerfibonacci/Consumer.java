/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerfibonacci;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class Consumer implements Runnable {

    ArrayBlockingQueue<Long> s1;
    ArrayBlockingQueue<Long> s2;

    public Consumer(ArrayBlockingQueue<Long> s1,ArrayBlockingQueue<Long> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        long sum = 0;
        while (!s2.isEmpty()) {
            try {
                long toSout = s2.take();
                
                sum = sum + toSout;
                
                System.out.println(toSout);
                System.out.println("Total: " + sum);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Final Total: " +sum);

    }

}
