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
public class ProducerConsumerFibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Long> nums = new ArrayList<>();
        nums.add((long) 4);
        nums.add((long) 5);
        nums.add((long) 8);
        nums.add((long) 12);
        nums.add((long) 21);
        nums.add((long) 22);
        nums.add((long) 34);
        nums.add((long) 35);
        nums.add((long) 36);
        nums.add((long) 37);
        nums.add((long) 42);

        ArrayBlockingQueue s1 = new ArrayBlockingQueue(nums.size());
        ArrayBlockingQueue s2 = new ArrayBlockingQueue(nums.size());

        for (int i = 0; i < nums.size(); i++) {
            try {
                s1.put(nums.get(i));
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumerFibonacci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Thread p1 = new Thread(new Producer(s1, s2));
        Thread p2 = new Thread(new Producer(s1, s2));
        Thread p3 = new Thread(new Producer(s1, s2));
        Thread p4 = new Thread(new Producer(s1, s2));

        Thread c1 = new Thread(new Consumer(s1, s2));

        p1.start();
        p2.start();
        p3.start();
        p4.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProducerConsumerFibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }

        c1.start();
    }

}
