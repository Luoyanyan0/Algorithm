package multi.thread.concurrentool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: yanyan.luo
 * @Description: isBroken()了解阻塞的线程是否被中断
 * @Date: Created in 11:53 2019/7/31
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName());
                    c.await();
                } catch (Exception e) {
                    System.out.println("0--"+c.isBroken());
                }
            }
        });

        System.out.println(c.getNumberWaiting());
        thread.start();
        thread.interrupt();
        System.out.println(c.getNumberWaiting());

        try {
            System.out.println(Thread.currentThread().getName());
            c.await();
        } catch (Exception e) {
            System.out.println("main--"+c.isBroken());
        }
    }
}
