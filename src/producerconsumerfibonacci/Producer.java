/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerfibonacci;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class Producer implements Runnable {

    ArrayBlockingQueue s1;
    ArrayBlockingQueue s2;

    public Producer(ArrayBlockingQueue s1, ArrayBlockingQueue s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {

        while (s1.peek()!=null) {
            try {
                long result = fib((long) s1.poll());
                s2.put(result);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Producer finished");
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
