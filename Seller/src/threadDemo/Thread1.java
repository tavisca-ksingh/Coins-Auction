package threadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread1 implements Runnable {
    private final BlockingQueue queue;
    public Thread1(BlockingQueue queue) { this.queue = queue; }
    public void run() {
        for(int i=0; i<=10; i++) {
            try {
                queue.put(i+2);
                System.out.println("Thread 1");
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}