package threadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread2  implements Runnable {
    private final BlockingQueue queue;
    public Thread2(BlockingQueue queue) { this.queue = queue; }
    public void run() {
        for(int i=0; i<=10; i++) {
            try {
                System.out.println("Thread 2 : " + queue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}