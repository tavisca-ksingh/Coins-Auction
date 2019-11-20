package threadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadMain {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        Thread t1 = new Thread(new Thread1(queue));
        Thread t2 = new Thread(new Thread2(queue));
        t1.start();
        t2.start();
    }
}
